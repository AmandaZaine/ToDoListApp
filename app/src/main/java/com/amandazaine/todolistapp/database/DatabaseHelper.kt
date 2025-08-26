package com.amandazaine.todolistapp.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "todolist.db"
        const val DATABASE_VERSION = 1
        const val TABLE_TASK = "task"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table if not exists $TABLE_TASK (" +
                  "id integer not null primary key autoincrement, " +
                  "description varchar(100), " +
                  "creation_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP" +
                  ");"

        try {
            db?.execSQL(sql)
            Log.i("info_db", "Success creating table")
        } catch(e: Exception) {
            e.printStackTrace()
            Log.i("info_db", "Failed to create table")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }
}