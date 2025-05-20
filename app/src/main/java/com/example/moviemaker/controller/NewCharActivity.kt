package com.example.moviemaker.controller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.moviemaker.R
import com.example.moviemaker.data.FilmeDAO
import com.example.moviemaker.model.Filme

class NewCharActivity : AppCompatActivity() {

    private lateinit var filmeDao: FilmeDAO
    private var idFilme: Int = 0
    private lateinit var etName: EditText
    private lateinit var etYear: EditText
    private lateinit var etGenre: EditText
    private lateinit var etSinopse: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_char)

        filmeDao = FilmeDAO(this)

        etName = findViewById(R.id.etName)
        etYear = findViewById(R.id.etYear)
        etGenre = findViewById(R.id.etGenre)
        etSinopse = findViewById(R.id.etSinopse)
        btnSave = findViewById(R.id.btnSave)

        idFilme = intent.getIntExtra("id_filme", 0)

        if (idFilme != 0) {
            val filme = filmeDao.getFilmById(idFilme)
            if (filme != null) {
                etName.setText(filme.nome)
                etYear.setText(filme.data_lancamento)
                etGenre.setText(filme.genero)
                etSinopse.setText(filme.sinopse)
            }
        }
    }

    fun saveChar(view: View) {
        if (etName.text.isNotEmpty() &&
            etYear.text.isNotEmpty() &&
            etGenre.text.isNotEmpty() &&
            etSinopse.text.isNotEmpty()
        ) {
            val filme = Filme(
                id_filme = idFilme,
                nome = etName.text.toString(),
                data_lancamento = etYear.text.toString(),
                genero = etGenre.text.toString(),
                sinopse = etSinopse.text.toString()
            )

            if (idFilme == 0) {
                filmeDao.insert(filme)
                Toast.makeText(this, "Filme Adicionado", Toast.LENGTH_SHORT).show()
            } else {
                filmeDao.update(filme)
                Toast.makeText(this, "Filme Atualizado", Toast.LENGTH_SHORT).show()
            }

            finish()
        } else {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
        }
    }
}
