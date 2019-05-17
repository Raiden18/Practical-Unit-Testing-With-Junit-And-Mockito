package com.raiden.learningunittest.chapter6.interactiontesting

import com.raiden.learningunittest.chapter5.SecurityService
import com.raiden.learningunittest.chapter5.User
import com.raiden.learningunittest.chapter5.UserDAO

class UserServerImpl(private val userDao: UserDAO, private val securityService: SecurityService) {

    fun assignPassword(user: User) {
        val passwordMd5 = securityService.md5(user.password)
        user.password = passwordMd5
        userDao.updateUser(user)
    }
}