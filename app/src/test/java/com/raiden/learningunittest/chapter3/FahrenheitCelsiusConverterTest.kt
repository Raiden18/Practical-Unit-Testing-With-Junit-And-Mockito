package com.raiden.learningunittest.chapter3

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class FahrenheitCelsiusConverterTest {
    private val converter = FahrenheitCelsiusConverter()

    fun getCelsiusAndFahrenheit() = arrayOf(
        arrayOf(0f, 32f),
        arrayOf(37f, 98.6f),
        arrayOf(100f, 212f)
    )

    @Test
    @Parameters(method = "getCelsiusAndFahrenheit")
    fun `must convert celsius to fahrenheit`(celsius: Float, fahrenheit: Float) {
        assertEquals(fahrenheit, converter.toFahrenheit(celsius))
    }

    @Test
    @Parameters(method = "getCelsiusAndFahrenheit")
    fun `must convert fahrenheit to celsius`(celsius: Float, fahrenheit: Float) {
        assertEquals(celsius, converter.toCelsius(fahrenheit))
    }
}