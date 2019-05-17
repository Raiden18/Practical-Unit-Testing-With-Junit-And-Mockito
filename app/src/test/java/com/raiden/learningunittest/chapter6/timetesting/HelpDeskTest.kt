package com.raiden.learningunittest.chapter6.timetesting

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

class HelpDeskTest {
    private lateinit var helpDesk: HelpDesk
    private lateinit var calendar: MyCalendar

    @Before
    fun setUp() {
        calendar = mock(MyCalendar::class.java)
        helpDesk = HelpDesk(calendar)
    }

    @Test
    fun `Should return false if day is sunday`(){
        `when`(calendar.getDay()).thenReturn(Calendar.SUNDAY)
        val isDayOff = helpDesk.willHandleIssue()
        assertFalse(isDayOff)
    }

    @Test
    fun `Should return false if day Saturday`(){
        `when`(calendar.getDay()).thenReturn(Calendar.SATURDAY)
        val isDayOff = helpDesk.willHandleIssue()
        assertFalse(isDayOff)
    }

    @Test
    fun `Should return false if day friday and hours are more seventeen`(){
        `when`(calendar.getDay()).thenReturn(Calendar.FRIDAY)
        `when`(calendar.getHour()).thenReturn(18)
        val isDayOff = helpDesk.willHandleIssue()
        assertFalse(isDayOff)
    }

    @Test
    fun `Should return true if day friday and hours are  seventeen`(){
        `when`(calendar.getDay()).thenReturn(Calendar.FRIDAY)
        `when`(calendar.getHour()).thenReturn(16)
        val isDayOff = helpDesk.willHandleIssue()
        assertTrue(isDayOff)
    }
}