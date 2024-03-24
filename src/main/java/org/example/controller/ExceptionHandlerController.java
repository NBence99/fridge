package org.example.controller;

import org.example.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found")
    @ExceptionHandler(ProductNotFoundException.class)
    public void productNotFoundExceptionHandler(){

    }
}
