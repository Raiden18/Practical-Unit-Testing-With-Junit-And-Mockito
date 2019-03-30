package com.raiden.learningunittest.chapter5

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*

class UserServiceImplTest {
    private companion object {
        const val PASSWORD = "123"
        const val MD5_PASSWORD = "321"
    }
    private lateinit var userServiceImpl: UserServiceImpl
    private lateinit var userDao: UserDAO
    private lateinit var securityService: SecurityService
    private lateinit var user: User

    @Before
    fun setUp() {
        userDao = mock(UserDAO::class.java)
        securityService = mock(SecurityService::class.java)
        `when`(securityService.md5(PASSWORD)).thenReturn(MD5_PASSWORD)
        userServiceImpl = UserServiceImpl(userDao, securityService)
        user = User(PASSWORD)
    }

    @Test
    fun `User must get his new password`(){
        `when`(securityService.md5(PASSWORD)).thenReturn("321")
        val passwordMd5 = securityService.md5(PASSWORD)
        userServiceImpl.assignPassword(user)
        assertEquals(user.password, passwordMd5)
    }

    @Test
    fun `Method updateUser must be called`(){
        userServiceImpl.assignPassword(user)
        verify(userDao).updateUser(user)
    }

}