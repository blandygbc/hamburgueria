package com.blandygbc.hamburgueria.domain.alimento

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Alimento(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val nome: String,
    val descricao: String,
    val preco: BigDecimal,
    val categoria: String
) {
    fun update(alimUpdate: AlimentoUpdate): Alimento {
        return this.copy(
            nome = alimUpdate.nome ?: this.nome,
            descricao = alimUpdate.descricao ?: this.descricao,
            preco = alimUpdate.preco ?: this.preco,
            categoria = alimUpdate.categoria ?: this.categoria
        )
    }
}
