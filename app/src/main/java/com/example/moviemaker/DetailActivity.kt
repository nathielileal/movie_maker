package com.example.moviemaker

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.moviemaker.controller.NewCharActivity
import com.example.moviemaker.data.FilmeDAO

class DetailActivity : AppCompatActivity() {
    private var idFilme: Int = -1
    private lateinit var dao: FilmeDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        idFilme = intent.getIntExtra("id_filme", -1)
        dao = FilmeDAO(this)

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

    fun onExcluirClick(view: View) {
        if (idFilme != -1) {
            excluirFilme(idFilme)
        }
    }

    fun onEditarClick(view: View) {
        if (idFilme != -1) {
            editarFilme(idFilme)
        }
    }

    fun excluirFilme(idFilme: Int) {
        val dao = FilmeDAO(this)
        val linhasAfetadas = dao.delete(idFilme)

        if (linhasAfetadas > 0) {
            Toast.makeText(this, "Filme excluído com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Falha ao excluir o filme.", Toast.LENGTH_SHORT).show()
        }
    }

    fun editarFilme(idFilme: Int) {
        val intent = Intent(this, NewCharActivity::class.java)
        intent.putExtra("id_filme", idFilme)
        startActivity(intent)
    }
}