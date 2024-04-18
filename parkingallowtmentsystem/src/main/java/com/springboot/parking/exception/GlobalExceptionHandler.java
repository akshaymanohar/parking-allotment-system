package com.springboot.parking.exception;

import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HttpStatus.BAD_REQUEST)
    public RequestEntity<String> handleResourceAlreadyExistExceptiom(ResourceAlreadyExist resourceAlreadyExist){

        return ResponseEntity<>

    }
}
