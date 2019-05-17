package com.raiden.learningunittest.chapter8.exercise3

import org.junit.AssumptionViolatedException
import org.junit.rules.TestWatcher
import org.junit.runner.Description

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class ExecutionTimeListener : TestWatcher() {

    private val startTimes = HashMap<String, Long>()

    val executionResults: Map<String, Long> = TreeMap()

    override fun starting(description: Description?) {
        startTimes[description!!.methodName] = System.currentTimeMillis()
    }

    override fun succeeded(description: Description?) {
        saveResults("ok", description!!)
    }

    override fun skipped(e: AssumptionViolatedException, description: Description) {
        saveResults("SKIPPED", description)
    }

    override fun failed(e: Throwable?, description: Description?) {
        saveResults("FAIL", description!!)
    }

    private fun saveResults(status: String, description: Description) {
        val executionTimeInMillis = System.currentTimeMillis() - startTimes[description.methodName]!!

        val df = SimpleDateFormat("ss:SSS")
        val formattedTime = df.format(executionTimeInMillis)

        ExecutionResultsHolder.put(
            String.format(
                "%-7s"
                        + "%-80s" + " " + " %-10s", status, description.className +
                        "." + description.methodName, formattedTime
            ),
            executionTimeInMillis
        )
    }
}
