package com.example.funcsaisu.ClientDatabase

import androidx.room.*

@Dao
interface ClientDAO {
    @Insert
    fun insert(client: Client_e)

    @Update
    fun update(client : Client_e)

    @Delete
    fun delete(client : Client_e)

    @Query("delete from client")
    fun deleteAll()

    @Query("select * from client")
    fun getAll():List<Client_e>

    @Query("select * from client where id = :id")
    fun getUser(id: Int): Client_e

}