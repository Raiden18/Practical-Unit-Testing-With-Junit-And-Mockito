package com.raiden.learningunittest.chapter4.bookingsystem

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.IllegalStateException

@RunWith(JUnitParamsRunner::class)
class BookingSystemTest {
    private lateinit var timeLine: BookingSystem

    @Before
    fun setUp() {
        timeLine = BookingSystem()
    }

    @Test
    fun `BookingSystem must allow to book if hourFrom and hourTo are the same in difference hours`() {
        timeLine.book(BookingHour(1, 12))
        timeLine.book(BookingHour(12, 13))
    }

    fun getCollisionsHours() = arrayOf(
        arrayOf(BookingHour(1, 12), BookingHour(2, 15)),
        arrayOf(BookingHour(2, 3), BookingHour(1, 15)),
        arrayOf(BookingHour(1, 3), BookingHour(2, 15)),
        arrayOf(BookingHour(0, 2), BookingHour(1, 2))
    )

    @Parameters(method = "getCollisionsHours")
    @Test(expected = IllegalStateException::class)
    fun `BookingSystem must throw exception if a hour collision exists`(hour1: BookingHour, hour2: BookingHour) {
        timeLine.book(BookingHour(hour1.hourFrom, hour1.hourTo))
        timeLine.book(BookingHour(hour2.hourFrom, hour2.hourTo))
    }
}