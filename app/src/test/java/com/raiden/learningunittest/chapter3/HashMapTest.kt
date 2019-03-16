package com.raiden.learningunittest.chapter3

import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class HashMapTest {
    private val hashMap = HashMap<String, String>()

    companion object {
        private const val KEY = "KEY"
        private const val VALUE = "VALUE"
    }

    @Before
    fun setUp() {
        hashMap[KEY] = VALUE
    }

    @After
    fun clearHashMap(){
        hashMap.clear()
    }

    @Test
    fun `hashMap must return value`() {
        assertEquals(VALUE, hashMap[KEY])
    }

    @Test
    fun  `hashMap must replace value`(){
        val newValue = "NEW VALUE"
        hashMap[KEY] = newValue
        assertEquals(newValue, hashMap[KEY])
    }
}