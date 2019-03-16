package com.raiden.learningunittest.chapter3

import junitparams.JUnitParamsRunner
import junitparams.Parameters
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(JUnitParamsRunner::class)
class MoneyTest {

    fun getMoney() = arrayOf(
        arrayOf(10, "USD"),
        arrayOf(20, "EUR")
    )

    @Test
    @Parameters(method = "getMoney")
    fun `Constructor should set amount and currency`(amount: Int, currency: String) {
        val money = Money(amount, currency)
        assertEquals(amount, money.amount)
        assertEquals(currency, money.currency)
    }
}