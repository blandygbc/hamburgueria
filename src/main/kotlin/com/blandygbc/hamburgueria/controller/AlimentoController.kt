package com.blandygbc.hamburgueria.controller

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoRequest
import com.blandygbc.hamburgueria.service.AlimentoService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/alimento")
class AlimentoController(
    private val alimentoService: AlimentoService
) {
    @PostMapping
    fun salvar(@RequestBody alimentoReq: AlimentoRequest): Alimento {
        return alimentoService.salvar(alimentoReq)
    }

    @GetMapping
    fun buscarTodos():List<Alimento>{
        return alimentoService.buscarTodos()
    }

    @GetMapping("/{pesquisa}")
    fun buscarAlimento(@PathVariable pesquisa: String): Alimento{
        return alimentoService.buscarAlimento(pesquisa)
    }
}