package com.example.moviemaker.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

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

        val insertFilme1 = """
        INSERT INTO $TABLE_NAME (nome, data_lancamento, genero, sinopse)
        VALUES ('Como treinar o seu dragão', 
        '2010-03-26', 
        'Ação', 
        'Soluço é um jovem viking que não tem capacidade para lutar contra os dragões, como é a tradição local. Sua vida muda quando ele ajuda um dragão que lhe mostra toda a verdade. Juntos, eles tentam provar que dragões e humanos podem ser amigos.')
    """.trimIndent()

        val insertFilme2 = """
        INSERT INTO $TABLE_NAME (nome, data_lancamento, genero, sinopse)
        VALUES ('Como treinar o seu dragão', 
        '2014-06-19', 
        'Ação', 'Cinco anos se passaram desde que Soluço estabeleceu a paz com os dragões e vive em harmonia, na Ilha de Berk, com Banguela. Eles voam, apostam corridas e se divertem muito. Em uma destas aventuras, descobrem uma caverna secreta cheia de dragões. Agora, a dupla luta para proteger Berk de um guerreiro perigoso, chamado Drago Bludvist, que deseja controlar todos os dragões existentes.')
    """.trimIndent()

        db.execSQL(insertFilme1)
        db.execSQL(insertFilme2)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }
}