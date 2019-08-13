package com.raiden.learningunittest.chapter8.exercise2

import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

public class RetryTestEnhancedRule : TestRule {

    private var errors = arrayOf<Throwable?>()

    private var currentAttempt: Int = 0

    override fun apply(base: Statement, description: Description): Statement {
        val retryAnnotation = description.getAnnotation(Retry::class.java) ?: return base
        val times = retryAnnotation.times
        if (times < 1) {
            throw IllegalArgumentException(
                "@" + Retry::class.java.simpleName +
                        " can't be used with 'times' less than 1"
            )
        }
        errors = arrayOfNulls(times)

        return object : Statement() {
            override fun evaluate() {
                while (currentAttempt < times) {
                    try {
                        base.evaluate()
                        return
                    } catch (throwable: Throwable) {
                        errors[currentAttempt] = throwable
                        currentAttempt++
                    }

                }
                throw RetryException.from(errors.requireNoNulls())
            }
        }
    }
}
