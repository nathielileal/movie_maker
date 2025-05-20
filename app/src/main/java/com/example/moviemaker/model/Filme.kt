package com.example.moviemaker.model

data class Filme(
    val id_filme: Int,
    val nome: String,
    val data_lancamento: String,
    val genero: String,
    val sinopse: String
) {
    override fun toString(): String {
        return nome
    }
}