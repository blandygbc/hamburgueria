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
}