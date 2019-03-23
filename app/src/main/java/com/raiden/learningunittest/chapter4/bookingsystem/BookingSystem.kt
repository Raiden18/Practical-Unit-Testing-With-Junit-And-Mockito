package com.raiden.learningunittest.chapter4.bookingsystem

class BookingSystem {
    private val bookedHoursTimeLine = arrayListOf<Boolean>()
    val bookedHours = arrayListOf<BookingHour>()


    init {
        initTimeLine()
    }

    private fun initTimeLine() {
        for (i in 0..23) {
            bookedHoursTimeLine.add(false)
        }
    }

    fun book(bookingHour: BookingHour) {
        if (isCollision(bookingHour)) {
            throw IllegalStateException("There is collision - you should choose another time")
        } else {
            bookHours(bookingHour)
            bookedHours.add(bookingHour)
        }

    }

    fun isTimeFromBookedTimesEqualsTimeToFromTheList(bookingHour: BookingHour): Boolean{
       return bookedHours.find { bookingHour.hourFrom == it.hourTo } != null
    }

    private fun isCollision(bookingHour: BookingHour): Boolean {
        return bookedHoursTimeLine.subList(bookingHour.hourFrom, bookingHour.hourTo)
            .contains(true) && !isTimeFromBookedTimesEqualsTimeToFromTheList(bookingHour)
    }

    private fun bookHours(bookingHour: BookingHour) {
        for (index in bookingHour.hourFrom..bookingHour.hourTo){
            bookedHoursTimeLine[index] = true
        }
    }
}