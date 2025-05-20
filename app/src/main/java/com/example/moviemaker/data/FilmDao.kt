package com.seuprojeto.dao

import android.content.ContentValues
import android.content.Context
import com.example.moviemaker.data.db.DBHelper
import com.example.moviemaker.model.Filme

class FilmeDAO(context: Context) {

    private val dbHelper = DBHelper(context)

    fun getFilmeById(id: Int): Filme? {
        val db = dbHelper.readableDatabase
        val cursor = db.query(
            DBHelper.TABLE_NAME,
            arrayOf("id_filme", "nome", "data_lancamento", "genero", "sinopse"),
            "id_filme = ?",
            arrayOf(id.toString()),
            null, null, null
        )

        var filme: Filme? = null
        if (cursor.moveToFirst()) {
            filme = Filme(
                id_filme = cursor.getInt(cursor.getColumnIndexOrThrow("id_filme")),
                nome = cursor.getString(cursor.getColumnIndexOrThrow("nome")),
                data_lancamento = cursor.getString(cursor.getColumnIndexOrThrow("data_lancamento")),
                genero = cursor.getString(cursor.getColumnIndexOrThrow("genero")),
                sinopse = cursor.getString(cursor.getColumnIndexOrThrow("sinopse"))
            )
        }
        cursor.close()
        db.close()
        return filme
    }

    fun insert(filme: Filme): Long {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("nome", filme.nome)
            put("data_lancamento", filme.data_lancamento)
            put("genero", filme.genero)
            put("sinopse", filme.sinopse)
        }
        val id = db.insert(DBHelper.TABLE_NAME, null, values)
        db.close()
        return id
    }
}
