package com.raiden.learningunittest.chapter5

class UserServiceImpl(
    private val userDAO: UserDAO,
    private val securityService: SecurityService
) {
    fun assignPassword(user: User) {
        val passwordMd5 = securityService.md5(user.password)
        user.password = passwordMd5
        userDAO.updateUser(user)
    }
}
