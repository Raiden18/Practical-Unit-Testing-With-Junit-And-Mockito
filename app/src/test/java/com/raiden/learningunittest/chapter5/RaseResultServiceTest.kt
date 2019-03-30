package com.raiden.learningunittest.chapter5

import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class RaseResultServiceTest {
    lateinit var raceResult: RaceResult
    val message = mock(Message::class.java)

    @Before
    fun setUp() {
        raceResult = RaceResult()
    }


    @Test
    fun `Subscribed client should receive message`() {
        val client = mock(Client::class.java)
        raceResult.addSubscriber(client)
        raceResult.send(message)
        verify(client).recieve(message)
    }

    @Test
    fun `All subscribed clients should receive message`() {
        val clientA = mock(Client::class.java, "clientA")
        val clientB = mock(Client::class.java, "clientB")

        raceResult.addSubscriber(clientA)
        raceResult.addSubscriber(clientB)
        raceResult.send(message)

        verify(clientA).recieve(message)
        verify(clientB).recieve(message)
    }

    @Test
    fun `Should send only one message to multi subscriber`() {
        val client = mock(Client::class.java)
        raceResult.addSubscriber(client)
        raceResult.addSubscriber(client)
        raceResult.send(message)

        verify(client).recieve(message)
    }

    @Test
    fun `Unsubscribed client should not receive messages`() {
        val client = mock(Client::class.java)
        raceResult.addSubscriber(client)
        raceResult.removeSubscriber(client)

        raceResult.send(message)
        verify(client, never()).recieve(message)
    }
}