package com.blandygbc.hamburgueria.repository

import com.blandygbc.hamburgueria.domain.alimento.Alimento

interface AlimentoRepository {
    fun save(alimento: Alimento) : Alimento
}