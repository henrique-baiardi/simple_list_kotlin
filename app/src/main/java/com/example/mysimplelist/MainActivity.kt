package com.example.mysimplelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
//        list_view_produtos.adapter = produtosAdapter //android extension

        val listaProduto = findViewById<ListView>(R.id.list_view_produtos)
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        listaProduto.adapter = produtosAdapter

        val botaoNovoProduto = findViewById<Button>(R.id.btn_inserir)
        botaoNovoProduto.setOnClickListener{
            val produtoDigitado = txt_produto.text.toString()

            if(produtoDigitado.isNotEmpty()) {
                produtosAdapter.add(produtoDigitado)
                txt_produto.text.clear()
            }else{
                txt_produto.error = "Campo invalido"
            }
        }

    }
}