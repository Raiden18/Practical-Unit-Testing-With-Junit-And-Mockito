package com.raiden.learningunittest.chapter6.operatingsystem

import org.assertj.core.api.AbstractAssert
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat

class OsMatchers(private val os: Window) : AbstractAssert<OsMatchers, Window>(os, Window::class.java) {

    fun is128Bit(): OsMatchers {
        assertEquals(os.nbOfBits, 128)
        return this
    }

    fun wasReleaseIn(year: Int): OsMatchers {
        assertEquals(os.releaseYear, year)
        return this
    }

    fun hasVersion(version: Int): OsMatchers {
        assertEquals(os.version, version)
        return this
    }
}