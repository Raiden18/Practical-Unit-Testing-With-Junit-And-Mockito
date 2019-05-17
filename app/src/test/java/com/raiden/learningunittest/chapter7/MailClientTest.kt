package com.raiden.learningunittest.chapter7

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.internal.verification.VerificationModeFactory.times
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)
@PrepareForTest(EmailServer::class, MailClient::class)
class MailClientTest() {

    @Throws(Exception::class)
    @Test
    fun `Should create email`() {
        val legacyMailClient = MailClient()
        val email = Email("123", "123", "123")
        mockStatic(EmailServer::class.java)

        val address = "ruberoid55@gmail.com"
        val title = "Пиьсмо бабушке"
        val body = "Где пенсия?"

        PowerMockito.whenNew(Email::class.java).withArguments(address, title, body).thenReturn(email)
        legacyMailClient.sendEmail(address, title, body)

        PowerMockito.verifyStatic(times(1))
        EmailServer.sendEmail(email)
    }}