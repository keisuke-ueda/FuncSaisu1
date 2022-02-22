package com.example.funcsaisu.LoadDatabase

import androidx.room.*

@Dao
interface LoadDAO {
    @Insert
    fun insert(load : Load_e)

    @Update
    fun update(load : Load_e)

    @Delete
    fun delete(load : Load_e)

    @Query("delete from load")
    fun deleteAll()

    @Query("select * from load")
    fun getAll():List<Load_e>

    @Query("select * from load where id = :id")
    fun getUser(id: Int): Load_e

}