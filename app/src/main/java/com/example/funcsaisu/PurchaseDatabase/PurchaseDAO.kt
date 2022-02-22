package com.example.funcsaisu.PurchaseDatabase

import androidx.room.*

@Dao
interface PurchaseDAO {
    @Insert
    fun insert(purchase : Purchase_e)

    @Update
    fun update(purchase: Purchase_e)

    @Delete
    fun delete(purchase: Purchase_e)

    @Query("delete from purchase")
    fun deleteAll()

    @Query("select * from purchase")
    fun getAll():List<Purchase_e>

    @Query("select * from purchase where id = :id")
    fun getUser(id: Int): Purchase_e

}