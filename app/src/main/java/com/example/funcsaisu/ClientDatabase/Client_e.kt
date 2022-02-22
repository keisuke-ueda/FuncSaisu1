package com.example.funcsaisu.ClientDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.R.id


@Entity(tableName = "client")
data class Client_e(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "staff_name") val staffName: String?,
    @ColumnInfo(name = "old_address") val OldAddress: String?,
    @ColumnInfo(name = "old_stage") val OldStage: String?,
    @ColumnInfo(name = "old_ev") val OldEv: String?,
    @ColumnInfo(name = "tell") val Tell: String?,
    @ColumnInfo(name = "new_address") val NewAddress: String?,
    @ColumnInfo(name = "new_stage") val NewStage: String?,
    @ColumnInfo(name = "new_ev") val NewEv: String?,
    @ColumnInfo(name = "laborer") val Laborer: String?,
    @ColumnInfo(name = "worker") val Worker: String?,
    @ColumnInfo(name = "truck_2t") val truck2t: String?,
    @ColumnInfo(name = "truck_4t") val truck4t: String?,
    @ColumnInfo(name = "box") val Box: String?,
    @ColumnInfo(name = "seal") val Seal: String?,
    @ColumnInfo(name = "white_regimen") val whiteRegimen: String?,
    @ColumnInfo(name = "blue_regimen") val blueRegimen: String?,
    @ColumnInfo(name = "white_tape") val whiteTape: String?,
    @ColumnInfo(name = "green_tape") val greenTape: String?,
    @ColumnInfo(name = "bogie") val Bogie: String?,
    @ColumnInfo(name = "quilting") val Quilting: String?,
    @ColumnInfo(name = "rollsheet") val rollSheet: String?,
    @ColumnInfo(name = "memo") val Memo: String?
    )

/*
Client_e(
            id: Int,
            staffName: String,
            OldAddress: String,
            OldStage: String?,
            OldEv: String?,
            Tell: String?,
            NewAddress: String?,
            NewStage: String?,
            NewEv: String?,
            Laborer: String?,
            Worker: String?,
            truck2t: String?,
            truck4t: String?,
            Box: String?,
            Seal: String?,
            whiteRegimen: String?,
            blueRegimen: String?,
            whiteTape: String?,
            greenTape: String?,
            Bogie: String?,
            Quilting: String?,
            rollSheet: String?
            Memo: String?
        ) : (id,staffName,OldAddress,OldStage,OldEv,Tell,NewAddress,NewStage,NewEv,Laborer,Worker,truck2t,truck4t,Box,Seal,whiteRegimen,blueRegimen,whiteTape,greenTape,Bogie,Quilting,rollSheet,Memo)
    }

 */

