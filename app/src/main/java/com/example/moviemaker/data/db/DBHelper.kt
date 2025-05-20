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
            id_filme INTEGER PRIMARY KEY AUTOINCREMENT,
            nome TEXT NOT NULL,
            data_lancamento TEXT,
            genero TEXT,
            sinopse TEXT
        )
    """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}