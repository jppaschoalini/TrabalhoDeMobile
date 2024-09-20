package com.example.trabalhodemobile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalhodemobile.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    //linkando o xml a esse kotlin
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //muda de telas e pode ser usado para levar dados de uma tela para outra
        binding.criar.setOnClickListener{
            val intent = Intent(this, CriarConta::class.java)
            startActivity(intent)

        }
    }
}