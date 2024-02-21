package com.project.userproject.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import java.time.LocalDateTime

@ControllerAdvice
class GlobalExceptionHanddler {
    @ExceptionHandler(ResourceNotFoundException::class)
    fun resourceNotFoundException(ex: ResourceNotFoundException, request: WebRequest): ResponseEntity<ErrorResponse>{
        val errorDetails = ErrorResponse(
                timestamp = LocalDateTime.now(),
                message = ex.message,
                details = request.getDescription(false)
        )
   return ResponseEntity(errorDetails, HttpStatus.NOT_FOUND)
    }
    @ExceptionHandler(Exception::class)
    fun globalExceptionHanddler(ex: Exception, request: WebRequest): ResponseEntity<ErrorResponse>{
        val errorDetails = ErrorResponse(
                timestamp =
LocalDateTime.now(),
                message = ex.message,
                details = request.getDescription(false)
                )
   return ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}