package com.example.moviemaker.controller

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moviemaker.R
import com.example.moviemaker.data.FilmeDAO
import com.example.moviemaker.model.Filme

class NewCharActivity : AppCompatActivity() {

    private lateinit var FilmeDao : FilmeDAO
    private var id_filme : Int = 0
    private lateinit var etName : EditText
    private lateinit var etYear : EditText
    private lateinit var etGenre : EditText
    private lateinit var etSinopse : EditText
    private lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_char)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}