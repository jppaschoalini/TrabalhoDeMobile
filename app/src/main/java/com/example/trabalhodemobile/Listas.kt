package com.example.trabalhodemobile

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhodemobile.DB.DBlistas
import com.example.trabalhodemobile.databinding.ActivityListasBinding

class Listas : AppCompatActivity() {


    private lateinit var binding: ActivityListasBinding
    private lateinit var adapter: Lista_Adapter
    private val listaBD = DBlistas.instance


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listasList = listaBD.getListas()

        adapter = Lista_Adapter(listasList, ::onListItemClicked)
        val layoutManager = LinearLayoutManager(this)

        binding.RECYCLERVIEW.adapter = adapter
        binding.RECYCLERVIEW.layoutManager = layoutManager

        binding.CriarLista.setOnClickListener {
            val intent = Intent(this, AlterarListas::class.java)
            startActivity(intent)
        }

        binding.logout.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }


    }

    fun onListItemClicked(lista:estrutura_lista) {
        val intent = Intent(this, AlterarListas::class.java)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        atualizaTela()
    }

    fun atualizaTela() {
        val listasList = listaBD.getListas()
        adapter.updateList(listasList)
    }



}