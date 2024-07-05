package com.blandygbc.hamburgueria.domain.alimento

import java.math.BigDecimal

data class Alimento(
    var id: Long? = null,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
)
