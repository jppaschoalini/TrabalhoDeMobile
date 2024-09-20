package com.example.trabalhodemobile

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trabalhodemobile.databinding.ActivityMain2Binding
import com.example.trabalhodemobile.databinding.ActivityMainBinding

class CriarConta : AppCompatActivity() {


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


            //verifica se os espacos estao vazios e confirma se o usuario colocou a mesma senha
            if (nomeInserido.text.toString().isEmpty() || emailInserido.text.toString().isEmpty() ||
                senhaInserido.text.toString().isEmpty() || confirmar.text.toString().isEmpty() || confirmacao != senha) {

                Toast.makeText(this, "campo nao preenchido/senhas diferentes", Toast.LENGTH_SHORT).show()

            }else{



                //passa as informacoes dessa tela para outra tela expecificada
                val intent = Intent(this, Login::class.java)
                //intent.putExtra("nome", nome)
                //intent.putExtra("email", email)
                //intent.putExtra("senha", senha)
                startActivity(intent)
            }
        }


    }

}