package com.raiden.learningunittest.chapter4.bookingsystem

import java.lang.IllegalArgumentException
import java.util.*

data class BookHour(val hourFrom: Int, val hourTo: Int){
    init {
        if (hourTo < 0|| hourFrom < 0)
            throw IllegalArgumentException("Hour mustn't be negative")
        if (hourTo > 24|| hourFrom > 24)
            throw IllegalArgumentException("Hour mustn't be more than 24")
    }
}