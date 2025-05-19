package com.example.moviemaker.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaker.R
import com.example.moviemaker.model.Filme

class MainActivity : AppCompatActivity() {

    private fun createFilms() : List<Filme>{
        return listOf(
            Filme(1, "Filme1", 1999, "Terror", "lalala"),
            Filme(2, "Filme2", 1998, "Ação", "lololo")
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}