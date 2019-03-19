package com.raiden.learningunittest.chapter4

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test


class RegexTest {
    private val regex = Regex()
    @Test
    fun `List of numbers must be empty if there is no numbers with 3 and more digits`() {
        val string = "abc 12"
        assertTrue(
            "List of integers must be empty",
            regex.getNumber(string).isEmpty()
        )
    }

    @Test
    fun `Regex must find one integer`() {
        val string = "cdefg 345 12bb23"
        assertTrue(
            "List of integers must contain the 345 number",
            regex.getNumber(string).contains(345)
        )
    }

    @Test
    fun `Regex must finde two integers`() {
        val string = "cdefg 345 12bbb33 678tt"
        val integers = listOf(345, 678)
        assertEquals(
            "List of integers must contain 345 and 678 numbers",
            integers,
            regex.getNumber(string)
        )
    }
}