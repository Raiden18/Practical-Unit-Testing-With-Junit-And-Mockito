package com.raiden.learningunittest.chapter8.exercise3

import java.util.TreeMap

object ExecutionResultsHolder {

    private val executionResults = TreeMap<String, Long>()

    fun getExecutionResults(): Map<String, Long> {
        return executionResults
    }

    fun put(key: String, executionTime: Long?) {
        executionResults[key] = executionTime!!
    }

    fun reverseSortByValue(): Map<String, Long> {
        return MapUtil.reverseSortByValue(executionResults)
    }
}
