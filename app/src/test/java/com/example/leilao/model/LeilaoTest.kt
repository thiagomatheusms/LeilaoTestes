package com.example.leilao.model

import android.util.Log
import org.junit.Assert.assertEquals
import org.junit.Test

class LeilaoTest {

    private val console = Leilao("Console")
    private val usuario1 = Usuario("Thiago")

    //Como nomear o teste
    //[nome do método] [estado de teste] [resultado esperado]

    @Test
    fun getDescricao_WhenRecebeDescricao_ShouldMostrarDescricao() {
        // criar cenário de teste
        val leilao = Leilao("Console")

        // executar ação esperada
        val descricaoDevolvida = leilao.descricao

        //testar resultado esperado
        assertEquals("Console", descricaoDevolvida)
    }

    @Test
    fun getMaiorLance_WhenRecebeApenasUmLance_ShouldDevolverMaiorLance() {
        /* Cenário 1 - Um único lance*/

        //criar cenário de teste
        console.propoe(Lance(usuario1, 400.0))

        //executar ação esperada
        val maiorLanceDevolvido = console.maiorLance

        //testar resultado esperado
        assertEquals(400.0, maiorLanceDevolvido)
    }

    @Test
    fun getMaiorLance_WhenRecebeMaisDeUmLanceCrescente_ShouldDevolverMaiorLance() {
        /* Cenário 2 - Vários lances em ordem crescente*/

        //criar cenário de teste
        console.propoe(Lance(usuario1, 100.0))
        console.propoe(Lance(Usuario("Matheus"), 200.0))

        //executar ação esperada
        val maiorLanceDevolvido = console.maiorLance

        //testar resultado esperado
        assertEquals(200.0, maiorLanceDevolvido)
    }

    @Test
    fun getMaiorLance_WhenRecebeMaisDeUmLanceDecrescente_ShouldDevolverMaiorLance() {
        /* Cenário 3 - Vários lances em ordem decrescente*/

        //criar cenário de teste
        console.propoe(Lance(usuario1, 200.0))
        console.propoe(Lance(Usuario("Matheus"), 100.0))

        //executar ação esperada
        val maiorLanceDevolvido = console.maiorLance

        //testar resultado esperado
        assertEquals(200.0, maiorLanceDevolvido)
    }

    @Test
    fun getMenorLance_WhenRecebeApenasUmLance_ShouldDevolverMenorLance() {
        /* Cenário 1 - Um único lance*/

        //criar cenário de teste
        console.propoe(Lance(usuario1, 400.0))

        //executar ação esperada
        val menorLanceDevolvido = console.menorLance

        //testar resultado esperado
        assertEquals(400.0, menorLanceDevolvido)
    }

    @Test
    fun getMenorLance_WhenRecebeMaisDeUmLanceCrescente_ShouldDevolverMenorLance() {
        /* Cenário 2 - Vários lances em ordem crescente*/

        //criar cenário de teste
        console.propoe(Lance(usuario1, 100.0))
        console.propoe(Lance(Usuario("Matheus"), 200.0))

        //executar ação esperada
        val menorLanceDevolvido = console.menorLance

        //testar resultado esperado
        assertEquals(100.0, menorLanceDevolvido)
    }

    /*Após a inserção da feature "Não deve adicionar um lance menor que o maior lance atual" esse teste não é mais necessário*/
//    @Test
//    fun getMenorLance_WhenRecebeMaisDeUmLanceDecrescente_ShouldDevolverMenorLance() {
//        /* Cenário 3 - Vários lances em ordem decrescente*/
//
//        //criar cenário de teste
//        console.propoe(Lance(usuario1, 200.0))
//        console.propoe(Lance(Usuario("Matheus"), 100.0))
//
//        //executar ação esperada
//        val menorLanceDevolvido = console.menorLance
//
//        //testar resultado esperado
//        assertEquals(100.0, menorLanceDevolvido)
//    }

    @Test
    fun getTresMaioresLances_WhenRecebeExatosTresLances_ShouldDevolverTresMaioresLances() {

        //criar cenário de teste
        console.propoe(Lance(usuario1, 200.0))
        console.propoe(Lance(Usuario("Matheus"), 300.0))
        console.propoe(Lance(usuario1, 400.0))

        //executar ação esperada
        val tresMaioresLancesDevolvidos = console.tresMaioresLances()


        //testar resultado esperado
        assertEquals(3, tresMaioresLancesDevolvidos?.size)
        assertEquals(400.0, tresMaioresLancesDevolvidos?.get(0)?.valor)
        assertEquals(300.0, tresMaioresLancesDevolvidos?.get(1)?.valor)
        assertEquals(200.0, tresMaioresLancesDevolvidos?.get(2)?.valor)

    }

    @Test
    fun getTresMaioresLances_WhenNaoRecebeLances_ShouldDevolverTresMaioresLances() {

        //criar cenário de teste
        //nesse caso não tem

        //executar ação esperada
        val tresMaioresLancesDevolvidos = console.tresMaioresLances()

        //testar resultado esperado
        assertEquals(0, tresMaioresLancesDevolvidos?.size)
    }

    @Test
    fun getTresMaioresLances_WhenRecebeApenasUmLance_ShouldDevolverTresMaioresLances() {

        //criar cenário de teste
        console.propoe(Lance(usuario1, 200.0))

        //executar ação esperada
        val tresMaioresLancesDevolvidos = console.tresMaioresLances()

        //testar resultado esperado
        assertEquals(1, tresMaioresLancesDevolvidos?.size)
        assertEquals(200.0, tresMaioresLancesDevolvidos?.get(0)?.valor)

    }

    @Test
    fun getTresMaioresLances_WhenRecebeApenasDoisLance_ShouldDevolverTresMaioresLances() {

        //criar cenário de teste
        console.propoe(Lance(usuario1, 200.0))
        console.propoe(Lance(Usuario("Matheus"), 300.0))

        //executar ação esperada
        val tresMaioresLancesDevolvidos = console.tresMaioresLances()

        //testar resultado esperado
        assertEquals(2, tresMaioresLancesDevolvidos?.size)
        assertEquals(300.0, tresMaioresLancesDevolvidos?.get(0)?.valor)
        assertEquals(200.0, tresMaioresLancesDevolvidos?.get(1)?.valor)

    }

    @Test
    fun getTresMaioresLances_WhenRecebeMaisQue3Lances_ShouldDevolverTresMaioresLances() {

        //criar cenário de teste
        console.propoe(Lance(usuario1, 200.0))
        console.propoe(Lance(Usuario("Matheus"), 300.0))
        console.propoe(Lance(usuario1, 400.0))
        console.propoe(Lance(Usuario("Matheus"), 500.0))

        //executar ação esperada
        val tresMaioresLancesDevolvidos = console.tresMaioresLances()

        //testar resultado esperado
        assertEquals(3, tresMaioresLancesDevolvidos?.size)
        assertEquals(500.0, tresMaioresLancesDevolvidos?.get(0)?.valor)
        assertEquals(400.0, tresMaioresLancesDevolvidos?.get(1)?.valor)
        assertEquals(300.0, tresMaioresLancesDevolvidos?.get(2)?.valor)

    }

    @Test
    fun get_WhenNaoPossuiLances_ShouldDevolverZeroNoMaiorLance() {

        //criar cenário de teste

        //executar ação esperada
        val maiorLanceDevolvido = console.maiorLance

        //testar resultado esperado
        assertEquals(0.0, maiorLanceDevolvido)
    }

    @Test
    fun get_WhenNaoPossuiLances_ShouldDevolverZeroNoMenorLance() {
        //criar cenário de teste

        //executar ação esperada
        val menorLanceDevolvido = console.menorLance

        //testar resultado esperado
        assertEquals(0.0, menorLanceDevolvido)
    }

    @Test
    fun get_WhenLanceForMenorQueMaiorLance_ShouldNaoGravarOLanceAtual() {
        //criar cenário de teste
        console.propoe(Lance(usuario1, 200.0))
        console.propoe(Lance(usuario1, 100.0))

        //executar ação esperada
        val quantidadeLancesDevolvidos = console.lances?.size

        //testar ação esperada
        assertEquals(1, quantidadeLancesDevolvidos)
    }

    @Test
    fun get_WhenDoisLancesSeguidosSaoDoMesmoUsuario_ShouldNaoPermitirOSegundoLance() {
        //criar cenário de teste
        console.propoe(Lance(usuario1, 100.0))
        console.propoe(Lance(usuario1, 200.0))

        //executar ação esperada
        val quantidadeLancesDevolvidos = console.lances?.size

        //testar ação esperada
        assertEquals(1, quantidadeLancesDevolvidos)
    }

    @Test
    fun get_WhenUsuarioDaMaisDe5Lances_ShouldContarApenas5() {
        //criar cenário de teste
        console.propoe(Lance(usuario1, 100.0))
        console.propoe(Lance(Usuario("Matheus"), 200.0))
        console.propoe(Lance(usuario1, 300.0))
        console.propoe(Lance(Usuario("Matheus"), 400.0))
        console.propoe(Lance(usuario1, 500.0))
        console.propoe(Lance(Usuario("Matheus"), 600.0))
        console.propoe(Lance(usuario1, 700.0))
        console.propoe(Lance(Usuario("Matheus"), 800.0))
        console.propoe(Lance(usuario1, 900.0))
        console.propoe(Lance(Usuario("Matheus"), 1000.0))
        console.propoe(Lance(usuario1, 1100.0))
        console.propoe(Lance(Usuario("Matheus"), 1200.0))

        //executar ação esperada
        val quantidadeLancesDevolvidos = console.lances?.size

        //testar ação esperada
        assertEquals(10, quantidadeLancesDevolvidos)
    }

}