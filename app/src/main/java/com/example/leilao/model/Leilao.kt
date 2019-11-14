package com.example.leilao.model

import java.io.Serializable

class Leilao(var lances: MutableList<Lance>?, var maiorLance: Double?, var menorLance: Double?) :
    Serializable {

    var descricao: String? = null

    constructor (descricao: String) : this(null, null, null) {
        this.descricao = descricao
    }

    init {
        lances = mutableListOf()
        maiorLance = 0.0
        menorLance = 0.0
    }

    fun propoe(lance: Lance) {

        if (lance.valor < maiorLance!!) {
            return
        }

        if (checaUsuarioDoLance(lance)) {
            return
        }

        if (checarNumeroDeLancesUsuario(lance)) {
            return
        }

        lances?.add(lance)

        if (lances?.size == 1) {
            maiorLance = lance.valor
            menorLance = lance.valor
            return
        }

        calculaMaiorLance(lance)
        calculaMenorLance(lance)
    }


    private fun calculaMaiorLance(lance: Lance) {
        if (lance.valor > maiorLance!!) {
            maiorLance = lance.valor
        }
    }

    private fun calculaMenorLance(lance: Lance) {
        if (lance.valor < menorLance!!) {
            menorLance = lance.valor
        }
    }

    fun tresMaioresLances(): List<Lance>? {

        var quantidadeMaximaLances = lances?.size

        if (quantidadeMaximaLances!! > 3) {
            quantidadeMaximaLances = 3
        }

        return lances?.let { it ->
            val a = it.sortedByDescending {
                it.valor
            }
            a?.subList(0, quantidadeMaximaLances)
        }
    }

    fun checaUsuarioDoLance(lance: Lance): Boolean {
        if (!lances?.isEmpty()!! && lances?.last()?.usuario?.equals(lance.usuario)!!) {
            return true
        }
        return false
    }

    fun checarNumeroDeLancesUsuario(lance: Lance): Boolean {
        lances?.let {
            if (it.isNotEmpty()) {
                if (it.count { it2 ->
                        it2.usuario == lance.usuario
                    } == 5)
                    return true
            }
        }
        return false
    }
}