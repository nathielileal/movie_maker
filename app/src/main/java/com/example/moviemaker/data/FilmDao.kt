package com.example.moviemaker.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface FilmDao {
    @Query("SELECT * FROM films")
    fun getAll(): List<Film>

    @Query("SELECT * FROM films WHERE name LIKE '%' || :query || '%'")
    fun searchByName(query: String): List<Film>

    @Insert
    fun insert(film: Film)

    @Update
    fun update(film: Film)

    @Delete
    fun delete(film: Film)
}

