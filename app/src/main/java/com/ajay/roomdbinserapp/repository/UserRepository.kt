package com.ajay.roomdbinserapp.repository

import com.ajay.roomdbinserapp.roomdatabase.User
import com.ajay.roomdbinserapp.roomdatabase.UserDao

class UserRepository(val dao: UserDao) {

    //TODO: Insert function called
    suspend fun insert(user : User) {
        dao.insertUser(user)
    }


    //TODO: Fetching function called
    val users = dao.getUsers()
}