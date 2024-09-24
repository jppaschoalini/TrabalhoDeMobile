package com.example.trabalhodemobile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalhodemobile.databinding.ActivityItensBinding

class AlterarListas : AppCompatActivity() {

    val PICK_IMAGE_REQUEST = 1
    lateinit var foto : ImageView
    var imageUri: Uri? = null



    //linkando o xml a esse kotlin
    private lateinit var binding: ActivityItensBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_itens)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val lugarDeCompra : EditText = findViewById(R.id.nomelocal)
        val foto : ImageView = findViewById(R.id.imagem)

        binding = ActivityItensBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.adicionar.setOnClickListener{
            openGallery()
        }

    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            imageUri = data.data
            foto.setImageURI(imageUri)
        }
    }

}