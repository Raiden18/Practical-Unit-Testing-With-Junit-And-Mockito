package com.raiden.learningunittest.chapter6

import junit.framework.Assert.assertEquals
import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class TestReverseString {

    @Test
    fun `Should reverse string`(){
        val string = "123"
        val reversedString = "321";
        assertEquals(reversedString, string.reversed())
    }

    @Test
    fun `Should reverse string 222`(){
        val string = "222"
        val reversedString = "222"
        assertEquals(reversedString, string.reversed())
    }
}