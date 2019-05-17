package com.raiden.learningunittest.chapter8.exercise2

import org.junit.Assert
import org.junit.Rule
import org.junit.Test

public class EnhancedRetryTest {
    @get:Rule
    public var retryTestRule = RetryTestEnhancedRule()

    @Test
    @Retry(times = 3)
    fun shouldFailOnSecondAttempt() {
        firstTestCounter++
        Assert.fail("failing $firstTestCounter")
    }

    @Test
    @Retry(times = 4)
    fun shouldFailOnThirdAttempt() {
        secondTestCounter++
        Assert.fail("failing $secondTestCounter")
    }

    @Test
    fun shouldNotBeRerun() {
        thirdTestCounter++
        Assert.fail("failing $thirdTestCounter")
    }

    companion object {
        var firstTestCounter = 0
        var secondTestCounter = 0
        var thirdTestCounter = 0
    }
}