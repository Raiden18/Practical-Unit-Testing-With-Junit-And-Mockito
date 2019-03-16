package com.raiden.learningunittest.chapter3

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class StringUtilityTest {
    private var stringUtility = StringUtility()

    private fun getStrings() = arrayOf(
        "hello", "Paul", "P A U L", "JUNIT", " LI VE TypIn g  --", "123321", "*1281"
    )

    @Test
    @Parameters(method = "getStrings")
    fun `string must be reversed`(string: String) {
        Assert.assertEquals(stringUtility.reverse(string), string.reversed())
    }
}