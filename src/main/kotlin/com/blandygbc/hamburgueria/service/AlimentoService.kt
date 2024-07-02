package com.blandygbc.hamburgueria.service

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoRequest
import com.blandygbc.hamburgueria.repository.AlimentoRepository
import org.springframework.stereotype.Service

@Service
class AlimentoService(
    private val alimentoRepository: AlimentoRepository
) {
    fun salvar(alimentoRequest: AlimentoRequest): Alimento {
        return alimentoRepository.save(alimentoRequest.paraDominio())
    }
    fun buscarTodos(): List<Alimento> {
        return alimentoRepository.findAll()
    }

    fun buscarAlimento(pesquisa: String): Alimento {
        val id = pesquisa.toLongOrNull()
        if (id == null){
            return alimentoRepository.findByNome(pesquisa)
        }
        return alimentoRepository.findById(id)
    }
}