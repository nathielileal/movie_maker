package com.example.moviemaker.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,DATABASE_VERSION) {

    companion object {
        const val DATABASE_NAME = "movie_maker.db"
        const val DATABASE_VERSION = 1
        const val TABLE_NAME = "filme"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nome TEXT,
                casa TEXT
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(
        p0: SQLiteDatabase?,
        p1: Int,
        p2: Int
    ) {
        TODO("Not yet implemented")
    }
}