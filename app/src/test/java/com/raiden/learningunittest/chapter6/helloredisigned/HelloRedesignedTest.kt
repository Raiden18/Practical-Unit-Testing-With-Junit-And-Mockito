package com.raiden.learningunittest.chapter6.helloredisigned

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class HelloRedesignedTest {
    lateinit var timeProvider: TimeProvider
    lateinit var helloRedesigned: HelloRedesigned
    @Before
    fun setUp() {
        timeProvider = mock(TimeProvider::class.java)
        helloRedesigned = HelloRedesigned(timeProvider)
    }

    @Test
    fun `Should return Good Morning if time is before 12`() {
        `when`(timeProvider.getHour()).thenReturn(9)
        val message = helloRedesigned.sayHello()
        assertEquals("Good Morning", message)
    }
}