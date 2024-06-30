package com.blandygbc.hamburgueria.controller

import com.blandygbc.hamburgueria.domain.alimento.Alimento
import com.blandygbc.hamburgueria.domain.alimento.AlimentoRequest
import com.blandygbc.hamburgueria.service.AlimentoService
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
}