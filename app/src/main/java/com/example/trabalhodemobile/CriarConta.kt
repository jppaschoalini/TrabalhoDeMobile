package com.example.trabalhodemobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalhodemobile.databinding.ActivityMain2Binding
import java.util.regex.Pattern

class CriarConta : AppCompatActivity() {

    //---------------------------------------
    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "LoginPrefs"


    //linkando o xml a esse kotlin
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)



        //adquire os valores dos seu respectivos campos
        val nomeInserido: EditText = findViewById(R.id.NOME)
        val emailInserido: EditText = findViewById(R.id.EMAIL)
        val senhaInserido: EditText = findViewById(R.id.SENHA)
        val confirmar: EditText = findViewById(R.id.SENHAConfirmar)



        binding.criarConta.setOnClickListener {

            var nome = nomeInserido.text.toString()
            var email = emailInserido.text.toString()
            var senha = senhaInserido.text.toString()
            var confirmacao = confirmar.text.toString()


            //verifica se os espacos estao vazios se o email esta na estrutura correta
            // e confirma se o usuario colocou a mesma senha
            if (nomeInserido.text.toString().isEmpty() || emailInserido.text.toString().isEmpty() || emailValido(email) == false ||
                senhaInserido.text.toString().isEmpty() || confirmar.text.toString().isEmpty() || confirmacao != senha) {



                Toast.makeText(this, "campo nao preenchido ou senhas diferentes ou email invalido", Toast.LENGTH_SHORT).show()

            }else{

                val editor = sharedPreferences.edit()
                editor.putString("nome", nome)
                //editor.putString("email", email)
                editor.putString("${email}_senha", senha) // Chave única
                editor.apply()  // Salvar as mudanças



                //passa as informacoes dessa tela para outra tela expecificada
                val intent = Intent(this, Login::class.java)

                startActivity(intent)
            }





        }

    // valida se o email colocado esta na estrutura correta
    }
    private fun emailValido(email: String): Boolean{

        val patterns = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.+[A-Za-z]{2,6}\$"
        return email.matches(Regex(patterns))
    }
}