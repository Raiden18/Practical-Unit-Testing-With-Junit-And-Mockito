package com.raiden.learningunittest.chapter6.userlist

import com.raiden.learningunittest.chapter5.User

class UserList {
    val users = ArrayList<User>()

    fun addUser(user: User){
        users.add(user)
    }
}