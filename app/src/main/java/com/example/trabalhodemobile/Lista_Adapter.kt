package com.example.trabalhodemobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhodemobile.databinding.ActivityListasBinding
import com.example.trabalhodemobile.databinding.ItenLayoutBinding

class Lista_Adapter(private var listasDeCompras: List<estrutura_lista>,
                    private val onClick: (estrutura_lista) -> Unit) : RecyclerView.Adapter<Lista_Adapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItenLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var currentItem: estrutura_lista? = null

        init {
            itemView.setOnClickListener {
                currentItem?.let {
                    onClick(it)
                }
            }
        }

        fun bind(lista: estrutura_lista) {
            currentItem = lista
            binding.textTitulo.text = lista.getNome()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItenLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listasDeCompras[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = listasDeCompras.size

    fun updateList(novaLista: List<estrutura_lista>) {
        listasDeCompras = novaLista
        notifyDataSetChanged()
    }

}