package com.blandygbc.hamburgueria.service

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoNovo
import com.blandygbc.hamburgueria.domain.alimento.AlimentoUpdate
import com.blandygbc.hamburgueria.repository.AlimentoRepository
import org.springframework.stereotype.Service

@Service
class AlimentoService(private val alimentoRepository: AlimentoRepository) {
    fun salvar(alimentoNovo: AlimentoNovo): Alimento {
        return alimentoRepository.save(alimentoNovo.paraDominio())
    }

    fun buscarTodos(): List<Alimento> {
        return alimentoRepository.findAll()
    }

    fun buscarAlimento(pesquisa: String): Alimento {
        val id = pesquisa.toLongOrNull()
            ?: return alimentoRepository.findByNome(pesquisa)
        return alimentoRepository.findById(id)
    }

    fun removerAlimento(id: Long) {
        alimentoRepository.delete(id)
    }

    fun atualizarAlimento(idAlimento: Long, alimentoReq: AlimentoUpdate): Alimento? {
        return alimentoRepository.update(idAlimento, alimentoReq)
    }
}
