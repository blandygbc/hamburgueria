package com.blandygbc.hamburgueria.controller

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoNew
import com.blandygbc.hamburgueria.domain.alimento.AlimentoUpdate
import com.blandygbc.hamburgueria.service.AlimentoService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/alimento")
class AlimentoController(private val alimentoService: AlimentoService) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun salvar(@RequestBody alimentoNew: AlimentoNew): Alimento {
        return alimentoService.salvar(alimentoNew)
    }

    @GetMapping
    fun buscarTodos(): List<Alimento> {
        return alimentoService.buscarTodos()
    }

    @GetMapping("/{pesquisa}")
    fun buscarAlimento(@PathVariable pesquisa: String): Alimento {
        return alimentoService.buscarAlimento(pesquisa)
    }

    @DeleteMapping("/{idAlimento}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun removerAlimento(@PathVariable idAlimento: Long) {
        alimentoService.removerAlimento(idAlimento)
    }

    @PutMapping("/{idAlimento}")
    fun atualizarAlimento(
        @PathVariable idAlimento: Long,
        @RequestBody alimUpdate: AlimentoUpdate
    ): Alimento? {
        return alimentoService.atualizarAlimento(idAlimento, alimUpdate)
    }
}
