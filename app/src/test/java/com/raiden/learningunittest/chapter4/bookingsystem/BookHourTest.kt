package com.raiden.learningunittest.chapter4.bookingsystem

import org.junit.Test
import java.lang.IllegalArgumentException

class BookHourTest{

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a negative hourFrom`(){
        val timeFrom = -1
        val timeTo = 20
        BookingHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a hourFrom more than 24`(){
        val timeFrom = 25
        val timeTo = 20
        BookingHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a negative hourTo`(){
        val timeFrom = 20
        val timeTo = -1
        BookingHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a hourTo more than 24`(){
        val timeFrom = 1
        val timeTo = 25
        BookingHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if hourTo less than hourFrom is`() {
        val timeFrom = 23
        val timeTo = 1
        BookingHour(timeFrom,timeTo)
    }
}