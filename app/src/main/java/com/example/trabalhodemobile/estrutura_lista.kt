package com.example.trabalhodemobile

import android.graphics.Bitmap

class estrutura_lista (
    private var nome: String) {

    private var produtos: MutableList<estrutura_iten> = mutableListOf()

    fun getNome(): String {
        return nome
    }

    fun getListaProdutos(): MutableList<estrutura_iten> {
        return produtos;
    }


}