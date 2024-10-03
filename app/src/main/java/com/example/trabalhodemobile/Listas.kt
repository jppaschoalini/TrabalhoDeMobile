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

    private lateinit var sharedPreferences: SharedPreferences
    private val PREFS_NAME = "ListasPrefs"
    lateinit var recyclerView: RecyclerView
    lateinit var adapter:Lista_Adapter
    private val listaBD = DBlistas.instance

    private lateinit var binding: ActivityListasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

        binding = ActivityListasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        recyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        val listasList = listaBD.getListas()

        binding.RECYCLERVIEW.adapter = adapter
        binding.RECYCLERVIEW.layoutManager = layoutManager

        binding.CriarLista.setOnClickListener {
            val Criarconta = Intent(this, AlterarListas::class.java)
            startActivity(Criarconta)
        }

        binding.logout.setOnClickListener{
            val Telalogin = Intent(this, Login::class.java)
            startActivity(Telalogin)
        }
    }

    public override fun onResume() {
        super.onResume()
       loadLocais()
    }

    fun loadLocais() {
        val listasList = listaBD.getListas()
        adapter.updateList(listasList)

    }


}