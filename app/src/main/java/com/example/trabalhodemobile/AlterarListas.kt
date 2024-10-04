package com.example.trabalhodemobile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalhodemobile.DB.DBlistas
import com.example.trabalhodemobile.databinding.ActivityItensBinding

class AlterarListas : AppCompatActivity() {



    //linkando o xml a esse kotlin
    private lateinit var binding: ActivityItensBinding
    val listaBD = DBlistas.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_itens)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }




        val imagemSelecionada: ImageView = findViewById(R.id.imagem)



        binding.adicionarImagem.setOnClickListener {
            selectImage()
        }

        binding.adicionarLocal.setOnClickListener {

            val nome = binding.editListaNome.text.toString()
            val imagem = imagemSelecionada.toString()

            binding = ActivityItensBinding.inflate(layoutInflater)
            setContentView(binding.root)


            if (nome.isEmpty()) {

                Toast.makeText(this, "Por favor, insira um nome.", Toast.LENGTH_SHORT).show()

            } else {

                //imagem = selectedImageUri?.toString() ?: "android.resource://$packageName/drawable/template"

                val lista = estrutura_lista(nome)
                listaBD.adLista(lista)
                finish()
            }
        }

    }


    private fun selectImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivity(intent)
    }


}