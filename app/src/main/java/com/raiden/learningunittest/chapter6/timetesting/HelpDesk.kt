package com.raiden.learningunittest.chapter6.timetesting

import java.util.*

class HelpDesk(private val calendar: MyCalendar) {
    companion object {
        const val EOB_HOUR = 17
    }

    private var dayOfWeek = -1
    private var hour = -1

    fun willHandleIssue(): Boolean {
        dayOfWeek = calendar.getDay()
        hour = calendar.getHour()
        return !needGoToHome()
    }

    private fun needGoToHome() = isDayOff() || isLateOnFriday()

    private fun isLateOnFriday() = isFriday() && isHoursMoreEOB()

    private fun isDayOff() = isSunday() || isSaturday()

    private fun isSunday() = Calendar.SUNDAY == dayOfWeek

    private fun isSaturday() = Calendar.SATURDAY == dayOfWeek

    private fun isFriday() = Calendar.FRIDAY == dayOfWeek

    private fun isHoursMoreEOB() = hour > EOB_HOUR
}