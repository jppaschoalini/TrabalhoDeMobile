package com.example.trabalhodemobile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.trabalhodemobile.databinding.ActivityListasBinding
import com.example.trabalhodemobile.databinding.ItenLayoutBinding

class Lista_Adapter(private var ListaCompras: List<estrutura_lista>, private val onClick: (estrutura_lista) -> Unit) :
    RecyclerView.Adapter<Lista_Adapter.listaViewHolder>() {

    class listaViewHolder(val binding: ItenLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind (listas: estrutura_lista){

            binding.textTitulo.text = listas.getTitulo()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listaViewHolder {
        val binding = ItenLayoutBinding.inflate(LayoutInflater.from(parent.context))
        return listaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: listaViewHolder, position: Int) {
        val Lista = ListaCompras[position]
        holder.bind(Lista)
    }

    override fun getItemCount(): Int = ListaCompras.size

    fun updateList(novaLista: List<estrutura_lista>) {
        ListaCompras = novaLista
        notifyDataSetChanged()
    }

}