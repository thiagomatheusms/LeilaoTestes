package com.example.leilao

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.leilao.model.Leilao
import kotlinx.android.synthetic.main.activity_detalhe_leilao.*

class DetalheLeilaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_leilao)

        val intent = intent

        if (intent.hasExtra("LEILAO")) {
            val leilao = intent.getSerializableExtra("LEILAO") as Leilao
            tvNomeDetalhe.text = leilao.descricao
            tvDetalheMaiorLance.text = leilao.maiorLance.toString()
            tvDetalheMenotLance.text = leilao.menorLance.toString()

            var sb = StringBuilder()

            val lancesSort = leilao.lances?.sortedByDescending {
                it.valor
            }

            for (lance in lancesSort!!) {
                sb.append("${lance.valor} \n")
            }

            tvMaioresLances.text = sb.toString()
        }
    }
}
