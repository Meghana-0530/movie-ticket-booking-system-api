package com.example.movieticketbookingsystem.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class RestResponseBuilder {
    public <T> ResponseEntity<ResponseStructure<T>> sucess(HttpStatus statuscode, String message, T data){
        return ResponseEntity.status(statuscode).body(ResponseStructure.<T>builder()
                .Statuscode(statuscode.value())
                .message(message)
                .data(data)
                .build());
    }

    public ResponseEntity<ErrorStructure> errror(HttpStatus statuscode, String message){
        return ResponseEntity.status(statuscode).body(ErrorStructure.builder()
                .statuscode(statuscode.value())
                .errorMessage(message)
                .build());
    }
}