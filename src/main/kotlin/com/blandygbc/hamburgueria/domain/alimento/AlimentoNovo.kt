package com.blandygbc.hamburgueria.domain.alimento

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.math.BigDecimal

class AlimentoNovo(
    @field:NotBlank(message = " O nome é obrigatório")
    @field:Size(min = 3, max = 60, message = "O nome dever ter mais que 3 e menos que 60 caracteres")
    val nome: String?,
    @field:NotBlank(message = " A descrição é obrigatória")
    val descricao: String?,
    @field:NotNull(message = " O preço é obrigatório")
    @field:Min(value = 0, message = " O preço deve ser maior que 0")
    val preco: BigDecimal?,
    @field:NotBlank(message = " A categoria é obrigatória")
    @field:Size(max = 20, message = " A categoria deve ter menos que 20 caracteres")
    val categoria: String?
) {
    fun paraDominio(): Alimento {
        return Alimento(
            nome = this.nome!!,
            descricao = this.descricao!!,
            preco = this.preco!!,
            categoria = this.categoria!!
        )
    }
}
