package com.blandygbc.hamburgueria.service

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoNovo
import com.blandygbc.hamburgueria.domain.alimento.AlimentoUpdate
import com.blandygbc.hamburgueria.exception.ElementoNaoEncontradoException
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
            ?: return alimentoRepository
                .findByNome(pesquisa)
                .orElseThrow {
                    ElementoNaoEncontradoException("Alimento não encontrado")
                }

        return alimentoRepository
            .findById(id)
            .orElseThrow {
                ElementoNaoEncontradoException("Alimento não encontrado")
            }
    }

    fun removerAlimento(id: Long) {
        alimentoRepository.deleteById(id)
    }

    fun atualizarAlimento(idAlimento: Long, alimentoReq: AlimentoUpdate): Alimento? {
        val alimento = alimentoRepository
            .findById(idAlimento)
            .orElseThrow { ElementoNaoEncontradoException("Alimento não encontrado") }

        return alimentoRepository.save(alimento.update(alimentoReq))
    }
}
