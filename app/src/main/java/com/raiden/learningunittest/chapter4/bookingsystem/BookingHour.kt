package com.raiden.learningunittest.chapter4.bookingsystem

data class BookingHour(val hourFrom: Int, val hourTo: Int) {
    init {
        if (hourTo < 0 || hourFrom < 0)
            throw IllegalArgumentException("Hour mustn't be negative")
        if (hourTo > 24 || hourFrom > 24)
            throw IllegalArgumentException("Hour mustn't be more than 24")
        if (hourFrom > hourTo)
            throw IllegalArgumentException("hourFrom must be less than hourTo")
    }
}