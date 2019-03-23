package com.raiden.learningunittest.chapter5

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class MockitoReturningDesiredValueTest {
    private lateinit var myFerrari: Car
    @Before
    fun setUp(){
        myFerrari = mock(Car::class.java)
    }

    @Test
    fun `Test subbing`() {
        assertFalse(
            "New test double should return false as boolean",
            myFerrari.needsFuel
        )

        `when`(myFerrari.needsFuel).thenReturn(true)

        assertTrue(
            "After instructed test double should return what we want",
            myFerrari.needsFuel
        )
    }

    @Test
    fun `Test verification`() {
        myFerrari.driveTo("Sweet home Alabama")
        myFerrari.needsFuel

        verify(myFerrari).driveTo("Sweet home Alabama")
        verify(myFerrari).needsFuel
    }
}