package com.example.movieticketbookingsystem.exceptions.handler;

import com.example.movieticketbookingsystem.exceptions.UserExistByEmailException;
import com.example.movieticketbookingsystem.util.ErrorStructure;
import com.example.movieticketbookingsystem.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
public class UserExceptionHandler {
    private final RestResponseBuilder responseBuilder;
    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleUseExistByEmailException(UserExistByEmailException ex){
        return  responseBuilder.errror(HttpStatus.OK, ex.getMessage());
    }

}