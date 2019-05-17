package com.raiden.learningunittest.chapter6.helloredisigned

class HelloRedesigned(private val timeProvider: TimeProvider) {
    private var currentHour = -1
    fun sayHello(): String {
        currentHour = timeProvider.getHour()
        return if (isMore12()) "Good Morning" else "Good Evening"

    }

    private fun isMore12() = currentHour < 12
}