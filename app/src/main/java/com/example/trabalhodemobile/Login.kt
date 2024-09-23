package com.example.trabalhodemobile

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalhodemobile.databinding.ActivityMainBinding

class Login : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "LoginPrefs"

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

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)


        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val emailConfirmacao: EditText = findViewById(R.id.EMAIL)
        val senhaComfirmacao: EditText = findViewById(R.id.SENHA)



        binding.criar.setOnClickListener{

            //muda de telas para a tela de criar usuario
            val intent = Intent(this, CriarConta::class.java)
            startActivity(intent)

        }


        // confirma se o email e a senha existem, e muda de tela se existem
        binding.Acessar.setOnClickListener{

            val conEMAIL = emailConfirmacao.text.toString()
            val conSENHA = senhaComfirmacao.text.toString()

            val senhaArmazenada = sharedPreferences.getString("${conEMAIL}_senha", null)

            if (senhaArmazenada == null || senhaArmazenada != conSENHA) {


                Toast.makeText(this, "Email ou senha incorretos.", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, Listas::class.java)
                startActivity(intent)


            }
        }
    }
}