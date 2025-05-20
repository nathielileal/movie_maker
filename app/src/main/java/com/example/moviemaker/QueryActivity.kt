package com.example.moviemaker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaker.data.FilmeDAO

class QueryActivity : AppCompatActivity() {
    private lateinit var filmDao: FilmeDAO
    private lateinit var input: EditText
    private lateinit var result: TextView
    private lateinit var searchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query)

        input = findViewById(R.id.queryInput)
        result = findViewById(R.id.resultText)
        searchButton = findViewById(R.id.searchButton)

        filmDao = FilmeDAO(this)

        searchButton.setOnClickListener {
            buscar()
        }
    }

    private fun buscar() {
        val query = input.text.toString()
        val results = filmDao.search(query)
        if (results.isEmpty()) {
            result.text = "Nenhum filme encontrado."
        } else {
            result.text = results.joinToString("\n") { it.nome }
        }
    }
}
