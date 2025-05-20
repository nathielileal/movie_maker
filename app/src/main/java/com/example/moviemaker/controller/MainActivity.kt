package com.example.moviemaker.controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaker.R
import com.example.moviemaker.model.Filme
import android.widget.ListView
import android.widget.TextView
import com.example.moviemaker.data.FilmDao
import kotlinx.coroutines.ParentJob
import android.content.Intent

class MainActivity : AppCompatActivity() {

    private lateinit var filmDao : FilmDao
    private lateinit var listView: ListView
    private lateinit var emptyTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
<<<<<<< HEAD

        listView = findViewById(R.id.lvChars)
        emptyTextView = findViewById(R.id.tvEmpty)
        filmDao = FilmDao(this)
        listAllChars()

        listView.onItemClickListener { parent, view, position, id ->
            val selectedChar = parent.getItemAtPosition(position) as Filme
            val intent = Intent(this, DetailActivity::class.java)

        }
=======
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.queryInput)) { v, insets ->
       //     val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
       //     v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      //      insets
     //   }
>>>>>>> 947e4f1cee256f5a8fffba25a083f6b5ec597420
    }
}