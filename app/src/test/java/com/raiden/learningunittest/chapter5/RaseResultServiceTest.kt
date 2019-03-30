package com.raiden.learningunittest.chapter5

import com.raiden.learningunittest.chapter5.raceresult.Client
import com.raiden.learningunittest.chapter5.raceresult.RaceResult
import com.raiden.learningunittest.chapter5.raceresult.messages.BoatMessage
import com.raiden.learningunittest.chapter5.raceresult.messages.F1Message
import com.raiden.learningunittest.chapter5.raceresult.messages.HorseMessage
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import java.lang.IllegalStateException

class RaseResultServiceTest {
    private companion object {
        const val MESSAGE = "MESSAGE"
    }

    lateinit var raceResult: RaceResult
    val message = mock(BoatMessage::class.java)

    @Before
    fun setUp() {
        raceResult = RaceResult()
    }


    @Test
    fun `Subscribed client should receive message`() {
        val client = mock(Client::class.java)
        raceResult.addBoatRaceSubscriber(client)
        raceResult.sendBoatRaceMessage(message)
        verify(client).recieve(message)
    }

    @Test
    fun `All subscribed clients should receive message`() {
        val clientA = mock(Client::class.java, "clientA")
        val clientB = mock(Client::class.java, "clientB")

        raceResult.addBoatRaceSubscriber(clientA)
        raceResult.addBoatRaceSubscriber(clientB)
        raceResult.sendBoatRaceMessage(message)

        verify(clientA).recieve(message)
        verify(clientB).recieve(message)
    }

    @Test
    fun `Should send only one message to multi subscriber`() {
        val client = mock(Client::class.java)
        raceResult.addBoatRaceSubscriber(client)
        raceResult.addBoatRaceSubscriber(client)
        raceResult.sendBoatRaceMessage(message)

        verify(client).recieve(message)
    }

    @Test
    fun `Unsubscribed client should not receive messages`() {
        val client = mock(Client::class.java)
        raceResult.addBoatRaceSubscriber(client)
        raceResult.removeSubscriber(client)

        raceResult.sendBoatRaceMessage(message)
        verify(client, never()).recieve(message)
    }

    @Test
    fun `Subscribers should be able to receive message from different categories`() {
        val client = mock(Client::class.java)
        val f1Message = mock(F1Message::class.java)
        val boatMessage = mock(BoatMessage::class.java)
        val horseMessage = mock(HorseMessage::class.java)

        raceResult.addFormula1Subscriber(client)
        raceResult.addHorseRaceSubscriber(client)
        raceResult.addBoatRaceSubscriber(client)

        raceResult.sendFormula1Message(f1Message)
        raceResult.sendBoatRaceMessage(boatMessage)
        raceResult.sendHorseRaceMessage(horseMessage)

        verify(client).apply {
            recieve(f1Message)
            recieve(boatMessage)
            recieve(horseMessage)
        }
    }

    @Test
    fun `Subscribers shouldn't be able to receive message from another category`() {
        val client = mock(Client::class.java)
        val f1Message = mock(F1Message::class.java)
        val boatMessage = mock(BoatMessage::class.java)
        val horseMessage = mock(HorseMessage::class.java)

        addDifferentSubscribers(client)

        raceResult.sendFormula1Message(f1Message)
        raceResult.sendBoatRaceMessage(boatMessage)
        raceResult.removeSubscriber(client)
        raceResult.sendHorseRaceMessage(horseMessage)

        verify(client).apply {
            recieve(f1Message)
            recieve(boatMessage)
        }
        verify(client, never()).recieve(horseMessage)
    }

    @Test
    fun `Subscribers should receive any number of messages`() {
        val client = mock(Client::class.java)
        val f1Message = mock(F1Message::class.java)
        val boatMessage = mock(BoatMessage::class.java)
        val horseMessage = mock(HorseMessage::class.java)

        addDifferentSubscribers(client)
        for (i in 0..39) {
            raceResult.sendFormula1Message(f1Message)
            raceResult.sendBoatRaceMessage(boatMessage)
            raceResult.sendHorseRaceMessage(horseMessage)
        }

        verify(client, times(40)).apply {
            recieve(f1Message)
            recieve(boatMessage)
            recieve(horseMessage)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun `RaceResult should throws exception if unsubscribed user tries unsubscribe`(){
        val client = mock(Client::class.java)
        raceResult.removeSubscriber(client)
    }

    private fun addDifferentSubscribers(client: Client) {
        raceResult.addFormula1Subscriber(client)
        raceResult.addHorseRaceSubscriber(client)
        raceResult.addBoatRaceSubscriber(client)
    }


}