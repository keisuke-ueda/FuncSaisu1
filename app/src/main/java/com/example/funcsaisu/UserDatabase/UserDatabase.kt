package com.example.funcsaisu.UserDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.funcsaisu.ClientDatabase.ClientDAO
import com.example.funcsaisu.ClientDatabase.Client_e
import com.example.funcsaisu.LoadDatabase.LoadDAO
import com.example.funcsaisu.LoadDatabase.Load_e
import com.example.funcsaisu.PurchaseDatabase.PurchaseDAO
import com.example.funcsaisu.PurchaseDatabase.Purchase_e
import kotlinx.coroutines.DelicateCoroutinesApi


@Database(entities = [User::class,Client_e::class,Purchase_e::class,Load_e::class], version = 1, exportSchema = false)
abstract class UserDatabase:RoomDatabase() {

    abstract fun userDao(): UserDao

    abstract fun clientDao(): ClientDAO

    abstract fun purchaseDao(): PurchaseDAO

    abstract fun LoadDao():LoadDAO

    companion object {
        @Volatile
        private var instance :UserDatabase? = null

        @DelicateCoroutinesApi
        fun getInstance(context: Context): UserDatabase= instance?: synchronized(this){
            Room.databaseBuilder(context, UserDatabase::class.java, "User_Database.db").build()
        }
    }
}

