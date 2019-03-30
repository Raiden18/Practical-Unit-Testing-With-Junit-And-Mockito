package com.raiden.learningunittest.chapter5.raceresult

import com.raiden.learningunittest.chapter5.raceresult.messages.BoatMessage
import com.raiden.learningunittest.chapter5.raceresult.messages.F1Message
import com.raiden.learningunittest.chapter5.raceresult.messages.HorseMessage
import com.raiden.learningunittest.chapter5.raceresult.messages.Message
import java.lang.IllegalStateException

class RaceResult {
    val allSubscribers = mutableSetOf<Client>()
    private val f1Subscribers = mutableSetOf<Client>()
    private val horseSubscribers = mutableSetOf<Client>()
    private val boatSubscribers = mutableSetOf<Client>()

    fun removeSubscriber(client: Client) {
        var userWasRemoved = false
        if (f1Subscribers.contains(client)){
            f1Subscribers.remove(client)
            userWasRemoved = true;
        }
        if (horseSubscribers.contains(client)){
            horseSubscribers.remove(client)
            userWasRemoved = true
        }
        if (boatSubscribers.contains(client)){
            boatSubscribers.remove(client)
            userWasRemoved = true
        }
        if (!userWasRemoved) throw IllegalStateException("There are no such user")
    }

    fun addFormula1Subscriber(client: Client) {
        f1Subscribers.add(client)
    }

    fun addHorseRaceSubscriber(client: Client) {
        horseSubscribers.add(client)
    }

    fun addBoatRaceSubscriber(client: Client) {
        boatSubscribers.add(client)
    }

    fun sendFormula1Message(message: F1Message) {
        f1Subscribers.forEach { it.recieve(message) }
    }

    fun sendHorseRaceMessage(message: HorseMessage) {
        horseSubscribers.forEach { it.recieve(message) }
    }

    fun sendBoatRaceMessage(message: BoatMessage) {
        boatSubscribers.forEach { it.recieve(message) }
    }

}
