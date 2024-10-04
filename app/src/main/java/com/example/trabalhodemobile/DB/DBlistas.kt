package com.example.trabalhodemobile.DB

import com.example.trabalhodemobile.estrutura_lista

class DBlistas {
    companion object {
        var instance: DBlistas = DBlistas()
    }

    private var ListasDeCompras: MutableList<estrutura_lista> = mutableListOf()

    fun getListas(): List<estrutura_lista> {
        return ListasDeCompras
    }

    fun adLista(lista: estrutura_lista) {
        ListasDeCompras.add(lista)
    }
}