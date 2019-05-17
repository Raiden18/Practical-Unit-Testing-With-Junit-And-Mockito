package com.raiden.learningunittest.chapter6.helloredisigned

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

class TimeProviderImplTest {
    lateinit var calendar: Calendar
    lateinit var timeProvider: TimeProvider

    @Before
    fun setUp() {
        calendar = mock(Calendar::class.java)
        timeProvider = TimeProviderImpl(calendar)
    }

    fun `Should return hours`(){
        `when`(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(12)
        val time = timeProvider.getHour()
        assertEquals(12, time)
    }
}