package com.example.funcsaisu.UserDatabase

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user : User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("delete from users")
    fun deleteAll()

    @Query("select * from users")
    fun getAll():List<User>

    @Query("select * from users where id = :id")
    fun getUser(id: Int): User

    @Query("select id,client_name from users")
    fun getClient():List<User>

}