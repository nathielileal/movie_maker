package com.example.moviemaker

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaker.data.FilmeDAO

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val idFilme = intent.getIntExtra("id_filme", -1)
        val dao = FilmeDAO(this)

        val filme = dao.getFilmById(idFilme)

        if (filme != null) {
            findViewById<TextView>(R.id.nome).text = filme.nome
            findViewById<TextView>(R.id.lancamento).text = filme.data_lancamento
            findViewById<TextView>(R.id.genero).text = filme.genero
            findViewById<TextView>(R.id.sinopse).text = filme.sinopse
        } else {
            Toast.makeText(this, "Filme não encontrado!", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}