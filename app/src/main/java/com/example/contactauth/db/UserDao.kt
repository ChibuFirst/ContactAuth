package com.example.contactauth.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.contactauth.models.User

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User)

    @Query("SELECT * FROM user WHERE email = :email AND password = :password")
    fun findUser(email: String, password: String): User
}