package com.raiden.learningunittest.chapter5

class RaceResult {
    private val clients = mutableSetOf<Client>()

    fun addSubscriber(client: Client) {
        clients.add(client)
    }

    fun send(message: Message) {
        clients.forEach { it.recieve(message) }
    }

    fun removeSubscriber(client: Client?) {
        clients.remove(client)
    }

}
