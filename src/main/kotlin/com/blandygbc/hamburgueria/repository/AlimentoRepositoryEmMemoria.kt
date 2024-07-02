package com.blandygbc.hamburgueria.repository

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoUpdate
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class AlimentoRepositoryEmMemoria : AlimentoRepository {
    private var alimentoList: MutableList<Alimento> = ArrayList()
    private var indice: Long = 0

    init {
        alimentoList.addAll(
            listOf(
                Alimento(
                    ++indice,
                    "X-Tudo",
                    "descricao",
                    BigDecimal("22.60"),
                    "Hamburger"
                ),
                Alimento(
                    ++indice,
                    "X-Frango",
                    "descricao",
                    BigDecimal("22.60"),
                    "Hamburger"
                ),
                Alimento(
                    ++indice,
                    "X-Beacon",
                    "descricao",
                    BigDecimal("22.60"),
                    "Hamburger"
                ),
            )
        )
    }

    override fun save(alimento: Alimento): Alimento {
        indice += 1
        alimento.id = indice
        alimentoList.add(alimento)
        return alimento
    }

    override fun findAll(): List<Alimento> {
        return alimentoList
    }

    override fun findById(alimentoId: Long): Alimento {
        return alimentoList.first { it.id == alimentoId }
    }

    override fun findByNome(pesquisa: String): Alimento {
        return alimentoList.first { it.nome == pesquisa }
    }

    override fun delete(id: Long) {
        alimentoList.removeIf { it.id == id }
    }

    override fun update(
        id: Long,
        alimUpdate: AlimentoUpdate
    ): Alimento? {
        var alimentoAtualizado: Alimento? = null
        alimentoList.forEachIndexed { index, alimento ->
            if (alimento.id == id) {
                alimentoList[index] = alimento.copy(
                    nome = alimUpdate.nome ?: alimento.nome,
                    descricao = alimUpdate.descricao ?: alimento.descricao,
                    preco = alimUpdate.preco ?: alimento.preco,
                    categoria = alimUpdate.categoria ?: alimento.categoria
                )
                alimentoAtualizado = alimentoList[index]
            }
        }
        return alimentoAtualizado
    }
}
