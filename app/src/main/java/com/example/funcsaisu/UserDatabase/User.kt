package com.example.funcsaisu.UserDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

//https://somachob.com/android-room/#toc8

@Entity(tableName = "users")
data class User (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "client_name")val clientName: String?,
    @Ignore val lastName: String?,
    @Ignore val age: String?
    ){
        constructor(
            id: Int,
            clientName: String?
        ) : this(id,clientName,null,null)
    }
