package com.example.trabalhodemobile.DB

import com.example.trabalhodemobile.estrutura_lista

class DBlistas {
    companion object {
        var instance: DBlistas = DBlistas()
    }

    private var listaListasDeCompras: MutableList<estrutura_lista> = mutableListOf()

    fun getListas(): List<estrutura_lista> {
        return listaListasDeCompras
    }

    fun adLista(lista: estrutura_lista) {
        listaListasDeCompras.add(lista)
    }
}