package com.example.movieticketbookingsystem.exceptions.handler;

import com.example.movieticketbookingsystem.exceptions.TheaterNotFoundByIdException;
import com.example.movieticketbookingsystem.util.ErrorStructure;
import com.example.movieticketbookingsystem.util.RestResponseBuilder;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Service
@AllArgsConstructor
public class TheaterExceptionHandler {
    private final RestResponseBuilder responseBuilder;

    @ExceptionHandler
    public ResponseEntity<ErrorStructure> handleTheaterNotFoundByIdException(TheaterNotFoundByIdException ex){
        return responseBuilder.errror(HttpStatus.NOT_FOUND, "Theater with the requested ID not found");
    }

}