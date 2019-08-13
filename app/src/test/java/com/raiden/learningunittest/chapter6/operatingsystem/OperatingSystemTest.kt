package com.raiden.learningunittest.chapter6.operatingsystem



import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.Before
import org.junit.Test

class OperatingSystemTest {
    private lateinit var os: Window

    @Before
    fun setUp() {
        os = Window()
    }

    @Test
    fun `test using custom matchers`() {
        os.apply {
            nbOfBits = 128
            version = 9
            releaseYear = 2013

        }
    }
}