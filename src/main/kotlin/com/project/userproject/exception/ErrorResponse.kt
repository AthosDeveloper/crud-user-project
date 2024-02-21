package com.project.userproject.exception

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.time.LocalDateTime

data class ErrorResponse(
        val timestamp: LocalDateTime,
        val message: String?,
        val details: String
)