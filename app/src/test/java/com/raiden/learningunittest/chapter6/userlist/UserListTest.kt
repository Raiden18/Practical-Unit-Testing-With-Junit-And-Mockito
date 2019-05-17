package com.raiden.learningunittest.chapter6.userlist

import com.raiden.learningunittest.chapter5.User
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

class UserListTest {
    lateinit var userLists: UserList
    @Before
    fun setUp() {
        userLists = UserList()
    }

    @Test
    fun `Should return empty list of there are no users in the list`() {
        assertEquals(0, userLists.users.size)
    }

    @Test
    fun `List should be one size of there are no users in the list`() {
        userLists.addUser(User("asd"))
        assertEquals(1, userLists.users.size)
    }

    @Test
    fun `List should be two size of there are no users in the list`() {
        userLists.addUser(User("asd"))
        userLists.addUser(User("qwe"))
        assertEquals(2, userLists.users.size)
    }
}