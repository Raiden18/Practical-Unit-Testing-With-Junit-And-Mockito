package com.raiden.learningunittest.chapter4.bookingsystem

import org.junit.Test
import java.lang.IllegalArgumentException

class BookHourTest{

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a negative hourFrom`(){
        val timeFrom = -1
        val timeTo = 20
        BookHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a hourFrom more than 24`(){
        val timeFrom = 25
        val timeTo = 20
        BookHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a negative hourTo`(){
        val timeFrom = 20
        val timeTo = -1
        BookHour(timeFrom,timeTo)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `Book hour must throw exception if there is a hourTo more than 24`(){
        val timeFrom = 1
        val timeTo = 25
        BookHour(timeFrom,timeTo)
    }
}