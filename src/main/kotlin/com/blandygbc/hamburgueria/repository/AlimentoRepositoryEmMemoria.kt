package com.blandygbc.hamburgueria.repository

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import org.springframework.stereotype.Component

@Component
class AlimentoRepositoryEmMemoria: AlimentoRepository {
    private var alimentoList: MutableList<Alimento> = ArrayList()
    private var indice: Long = 0

    override fun save(alimento: Alimento): Alimento {
        indice+=1
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
}