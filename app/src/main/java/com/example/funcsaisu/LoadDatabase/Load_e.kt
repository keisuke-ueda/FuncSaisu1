package com.example.funcsaisu.LoadDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "load")
data class Load_e(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "client_name")val clientName: String?,
    @ColumnInfo(name = "load_name")val loadName: String?,
    @ColumnInfo(name = "size")val Size: String?,
    @ColumnInfo(name = "units")val Units: String?
    )
/*
        (
            id: Int,
            clientName: String?,
            loadName: String?,
            Size: String?,
            Units: String?

        ) : this@Purchase_e(id,clientName,null,null,null)

 */

