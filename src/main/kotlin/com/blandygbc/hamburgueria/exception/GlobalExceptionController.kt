package com.blandygbc.hamburgueria.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpServerErrorException.InternalServerError

@ControllerAdvice
class GlobalExceptionController {

    @ExceptionHandler
    fun handleInternalServerErrorException(ex: InternalServerError): ResponseEntity<MensagemException> {
        return getResponseEntity(
            statusCode = HttpStatus.INTERNAL_SERVER_ERROR,
            message = ex.message ?: "Erro interno do sistema"
        )
    }

    @ExceptionHandler
    fun handleNoSutchElementException(ex: NoSuchElementException): ResponseEntity<MensagemException> {
        return getResponseEntity(
            statusCode = HttpStatus.NOT_FOUND,
            message = ex.message ?: "Não encontrado"
        )
    }

    @ExceptionHandler
    fun handleElementoNaoEncontradoException(ex: ElementoNaoEncontradoException): ResponseEntity<MensagemException> {
        return getResponseEntity(
            statusCode = HttpStatus.NOT_FOUND,
            message = ex.message ?: "Não encontrado"
        )
    }

    @ExceptionHandler
    fun handleRuntimeException(ex: RuntimeException): ResponseEntity<MensagemException> {
        return getResponseEntity(
            statusCode = HttpStatus.BAD_REQUEST,
            message = ex.message ?: "Erro não previsto no sistema",
        )
    }

    @ExceptionHandler
    fun handleMethodArgumentNotValidException(ex: MethodArgumentNotValidException): ResponseEntity<List<ValidationErrorFields>> {
        return ResponseEntity
            .badRequest()
            .body(
                extrairErrosDeValidacao(ex)
            )
    }

    private fun extrairErrosDeValidacao(ex: MethodArgumentNotValidException): List<ValidationErrorFields> {
        return ex.bindingResult.allErrors.map {
            ValidationErrorFields(it as FieldError)
        }
    }

    private fun getResponseEntity(
        statusCode: HttpStatusCode,
        message: String,
    ): ResponseEntity<MensagemException> {
        return ResponseEntity(
            MensagemException(
                statusCode.value(),
                message,
            ),
            statusCode,
        )
    }

    class ValidationErrorFields(val field: String, val message: String) {
        constructor(error: FieldError) : this(
            field = error.field,
            message = error.defaultMessage ?: "Campo com informação inválida"
        )
    }
}