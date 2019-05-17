package com.raiden.learningunittest.chapter8.exercise2

import org.junit.Assert
import org.junit.Rule
import org.junit.Test

public class EnhancedRetryTest {
    @get:Rule
    public var retryTestRule = RetryTestEnhancedRule()
    var firstTestCounter = 0
    var secondTestCounter = 0
    var thirdTestCounter = 0
    @Test
    @Retry(times = 3)
    fun `should fail on secondAttempt`() {
        firstTestCounter++
        Assert.fail("failing $firstTestCounter")
    }

    @Test
    @Retry(times = 4)
    fun `should fail on third attempt`() {
        secondTestCounter++
        Assert.fail("failing $secondTestCounter")
    }

    @Test
    fun `should not be rerun`() {
        thirdTestCounter++
        Assert.fail("failing $thirdTestCounter")
    }
}