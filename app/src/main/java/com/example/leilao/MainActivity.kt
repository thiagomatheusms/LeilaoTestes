package com.example.leilao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.leilao.model.Lance
import com.example.leilao.model.Leilao
import com.example.leilao.model.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), LeilaoAdapter.myClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = LeilaoAdapter(this, null, this)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        val lista = mockLista()
        adapter.lista = lista
        adapter.notifyDataSetChanged()

    }

    fun mockLista(): List<Leilao> {
        val console = Leilao("Console")
        console.propoe(Lance(Usuario("Thiago"), 200.0))
        console.propoe(Lance(Usuario("Matheus"), 300.0))

        return ArrayList(listOf(console))
    }

    override fun onClickItem(leilao: Leilao) {
        val intent = Intent (this, DetalheLeilaoActivity::class.java)
        intent.putExtra("LEILAO", leilao)
        startActivity(intent)
    }
}
