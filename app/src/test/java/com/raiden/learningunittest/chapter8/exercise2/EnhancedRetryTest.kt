package com.raiden.learningunittest.chapter8.exercise2

import org.junit.Assert
import org.junit.Rule
import org.junit.Test

public class EnhancedRetryTest {
    @get:Rule
    var retryTestRule = RetryTestEnhancedRule()
    var firstTestCounter = 0
    var secondTestCounter = 0
    var thirdTestCounter = 0
    @Test
    @Retry(times = 3)
    fun `should fail on secondAttempt`() {
        firstTestCounter++
    }

    @Test
    @Retry(times = 4)
    fun `should fail on third attempt`() {
        secondTestCounter++
    }

    @Test
    fun `should not be rerun`() {
        thirdTestCounter++
    }
}