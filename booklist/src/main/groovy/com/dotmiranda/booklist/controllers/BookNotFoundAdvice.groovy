package com.dotmiranda.booklist.controllers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class BookNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(BookNotFoundException) // Configures advice to respond only to the BookNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND) // HTTP 404 Status
    String bookNotFoundHandler(BookNotFoundException exception) {
        return exception.getMessage()
    }
}
