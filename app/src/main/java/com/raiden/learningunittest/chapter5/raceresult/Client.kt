package com.raiden.learningunittest.chapter5.raceresult

import com.raiden.learningunittest.chapter5.raceresult.messages.Message

interface Client {
    fun recieve(message: Message?)
}
