package com.raiden.learningunittest.chapter6.helloredisigned

import java.util.*

class TimeProviderImpl(private val calendar: Calendar) : TimeProvider {
    override fun getHour(): Int = calendar.get(Calendar.HOUR_OF_DAY)
}