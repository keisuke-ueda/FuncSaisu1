package com.example.funcsaisu

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.StringBuilder

class DatabaseHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    //DB作成
    companion object{
        private const val DATABASE_NAME = "saisu.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase) {
        //メインテーブルの作成
        val sb_m = StringBuilder()
        sb_m.append("CREATE TABLE Main_table(")
        sb_m.append("_id INTEGER PRIMARY KEY,")
        sb_m.append("name TEXT,")
        sb_m.append("note TEXT")
        sb_m.append(");")
        val sql_m = sb_m.toString()
        db.execSQL(sql_m)

        /*
        //顧客情報テーブルの作成
        val sb_c = StringBuilder()
        sb_c.append("CREATE TABLE Client_table(")
        sb_c.append("_id INTEGER PRIMARY KEY,")
        sb_c.append("name TEXT,")
        sb_c.append("note TEXT")
        sb_c.append(");")
        val sql_c = sb_c.toString()
        db.execSQL(sql_c)

        //買取情報テーブルの作成
        val sb_p = StringBuilder()
        sb_p.append("CREATE TABLE Purchase_table(")
        sb_p.append("_id INTEGER PRIMARY KEY,")
        sb_p.append("name TEXT,")
        sb_p.append("note TEXT")
        sb_p.append(");")
        val sql_p = sb_c.toString()
        db.execSQL(sql_p)

        //廃棄情報テーブルの作成
        val sb_w = StringBuilder()
        sb_w.append("CREATE TABLE Waste_table(")
        sb_w.append("_id INTEGER PRIMARY KEY,")
        sb_w.append("name TEXT,")
        sb_w.append("note TEXT")
        sb_w.append(");")
        val sql_w = sb_c.toString()
        db.execSQL(sql_w)

        //荷物情報テーブルの作成
        val sb_l = StringBuilder()
        sb_l.append("CREATE TABLE Load_table(")
        sb_l.append("_id INTEGER PRIMARY KEY,")
        sb_l.append("name TEXT,")
        sb_l.append("note TEXT")
        sb_l.append(");")
        val sql_l = sb_c.toString()
        db.execSQL(sql_l)

         */

    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

}

