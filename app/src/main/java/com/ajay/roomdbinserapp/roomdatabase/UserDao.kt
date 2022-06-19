package com.ajay.roomdbinserapp.roomdatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User) : Long

    @Query("SELECT * FROM user_table")
    fun getUsers() : LiveData<List<User>>
}