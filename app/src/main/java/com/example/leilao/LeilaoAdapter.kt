package com.example.leilao

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.leilao.model.Leilao
import kotlinx.android.synthetic.main.item_leilao.view.*

class LeilaoAdapter(
    context: Context,
    var lista: List<Leilao>?,
    var mMyClickListener: myClickListener
) :
    RecyclerView.Adapter<LeilaoAdapter.ViewHolderLeilao>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLeilao {
        val context = parent.context
        val idLayout = R.layout.item_leilao
        val layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(idLayout, parent, false)

        return ViewHolderLeilao(view)
    }

    override fun getItemCount(): Int {
        return lista?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolderLeilao, position: Int) {
        lista?.get(position)?.let { holder.bindView(it) }
    }


    interface myClickListener {
        fun onClickItem(leilao: Leilao)
    }


    inner class ViewHolderLeilao(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            val leilao = lista?.get(position)

            leilao?.let {
                mMyClickListener.onClickItem(it)
            }
        }

        fun bindView(leilao: Leilao) {
            itemView.tvNomeItem.text = leilao.descricao
            itemView.tvMaiorLance.text = leilao.maiorLance.toString()
        }
    }

}