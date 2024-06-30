package com.blandygbc.hamburgueria.domain.alimento

import java.math.BigDecimal

class AlimentoRequest(
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
) {
    fun paraDominio(): Alimento{
        return Alimento(
            id = null,
            nome = this.nome,
            descricao = this.descricao,
            preco =  this.preco,
            categoria = this.categoria
        )
    }
}
