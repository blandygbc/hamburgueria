package com.blandygbc.hamburgueria.repository

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoUpdate

interface AlimentoRepository {
    fun save(alimento: Alimento): Alimento
    fun findAll(): List<Alimento>
    fun findById(alimentoId: Long): Alimento
    fun findByNome(pesquisa: String): Alimento
    fun delete(id: Long)
    fun update(id: Long, alimentoReq: AlimentoUpdate): Alimento?
}
