package com.raiden.learningunittest.chapter3

class FahrenheitCelsiusConverter {
    companion object {
    }

    fun toFahrenheit(celsius: Float): Float = (celsius * 9 / 5) + 32

    fun toCelsius(fahrenheit: Float): Float = ((fahrenheit - 32) * 5 / 9)
}