package com.raiden.learningunittest.chapter7

class MailClient {
    fun sendEmail(address: String, title: String, body: String) {
        val email = Email(address, title, body)
        EmailServer.sendEmail(email)
    }
}