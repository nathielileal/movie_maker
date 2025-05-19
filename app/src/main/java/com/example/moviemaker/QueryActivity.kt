package com.example.moviemaker

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class QueryActivity : AppCompatActivity() {
    private lateinit var filmDao: FilmDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_query)

        val input = findViewById<EditText>(R.id.queryInput)
        val result = findViewById<TextView>(R.id.resultText)
        val searchButton = findViewById<Button>(R.id.searchButton)

        filmDao = AppDatabase.getInstance(this).filmDao()

        searchButton.setOnClickListener {
            val query = input.text.toString()
            val results = filmDao.searchByName(query)
            result.text = results.joinToString("\n") { it.name }
        }
    }
}
