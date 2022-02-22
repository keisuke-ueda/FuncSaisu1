package com.example.funcsaisu.PurchaseDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "purchase")
data class Purchase_e (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "client_name")val clientName: String?,
    @ColumnInfo(name = "purchase_name")val purchaseName: String?,
    @ColumnInfo(name = "size")val Size: String?,
    @ColumnInfo(name = "units")val Units: String?
    )
/*
        (
            id: Int,
            clientName: String?,
            purchaseName: String?,
            Size: String?,
            Units: String?

        ) : this@Purchase_e(id,clientName,null,null,null)

 */

