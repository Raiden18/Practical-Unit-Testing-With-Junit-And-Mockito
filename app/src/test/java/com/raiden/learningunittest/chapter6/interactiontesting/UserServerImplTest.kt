package com.raiden.learningunittest.chapter6.interactiontesting

import com.raiden.learningunittest.chapter5.SecurityService
import com.raiden.learningunittest.chapter5.User
import com.raiden.learningunittest.chapter5.UserDAO
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.*

class UserServerImplTest {
    lateinit var userDao: UserDAO
    lateinit var securityService: SecurityService
    lateinit var userServer: UserServerImpl

    @Before
    fun setUp() {
        userDao = mock(UserDAO::class.java)
        securityService = mock(SecurityService::class.java)
        userServer = UserServerImpl(userDao, securityService)
    }

    @Test
    fun `Should get md5 password`() {
        val pass = "123"
        val hashPass = "321"
        `when`(securityService.md5(pass)).thenReturn(hashPass)
        val user = User(pass)
        userServer.assignPassword(user)
        assertEquals(hashPass, user.password)
    }

    @Test
    fun `Should coll security service`() {
        val pass = "123"
        val hashPass = "321"
        `when`(securityService.md5(pass)).thenReturn(hashPass)
        val user = User(pass)
        userServer.assignPassword(user)
        verify(securityService).md5(ArgumentMatchers.anyString())
    }
}