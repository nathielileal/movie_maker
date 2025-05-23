package com.example.moviemaker.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaker.DetailActivity
import com.example.moviemaker.QueryActivity
import com.example.moviemaker.R
import com.example.moviemaker.data.FilmeDAO
import com.example.moviemaker.model.Filme

class MainActivity : AppCompatActivity() {

    private lateinit var filmDao : FilmeDAO
    private lateinit var listView: ListView
    private lateinit var emptyTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.lvChars)
        emptyTextView = findViewById(R.id.tvEmpty)
        filmDao = FilmeDAO(this)
        listAllChars()

        listView.setOnItemClickListener  { parent, view, position, id ->
            val selectedChar = parent.getItemAtPosition(position) as Filme
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("id_filme", selectedChar.id_filme)
            }
            startActivity(intent)
        }

    }

    private fun listAllChars() {

        val chars = filmDao.get()
        if(chars.isEmpty()) {
            listView.visibility = ListView.GONE
            emptyTextView.visibility = TextView.VISIBLE
        } else {
            listView.visibility = ListView.VISIBLE
            emptyTextView.visibility = TextView.GONE

            val nomesDosFilmes = chars.map { it.nome }
            val adapter : ArrayAdapter<Filme> = ArrayAdapter(this, android.R.layout.simple_list_item_1, chars)
            listView.adapter = adapter
        }
    }

    fun newChar(view:View) {
        val intent = Intent(this, NewCharActivity::class.java)
        startActivity(intent)
    }

    fun searchChar(view:View) {
        val intent = Intent(this, QueryActivity::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        listAllChars()
    }
}
