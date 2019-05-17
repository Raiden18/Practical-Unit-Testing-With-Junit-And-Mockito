package com.raiden.learningunittest.chapter8.exercise3

import org.junit.AfterClass
import org.junit.Rule
import org.junit.Test

import org.junit.Assert.fail

class ExecutionTimeListenerDemoTest {

    @Rule
    var executionTimeListener = ExecutionTimeListener()

    @Test
    @Throws(InterruptedException::class)
    fun tenMillis() {
        Thread.sleep(1000)
    }

    @Test
    @Throws(InterruptedException::class)
    fun fiftyMillis() {
        Thread.sleep(500)
    }

    @Test
    @Throws(InterruptedException::class)
    fun failedAfterTenMillis() {
        Thread.sleep(145)
        fail()
    }

    companion object {

        @AfterClass
        fun printExecutionResults() {
            for ((key) in ExecutionResultsHolder.reverseSortByValue()) {
                println(key)
            }
        }
    }
}
