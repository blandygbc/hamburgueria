package com.blandygbc.hamburgueria.repository

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoUpdate
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface AlimentoRepository : JpaRepository<Alimento, Long> {
    fun findByNome(pesquisa: String): Optional<Alimento>
}
