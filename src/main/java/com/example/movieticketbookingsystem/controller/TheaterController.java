package com.example.movieticketbookingsystem.controller;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterResponse;
import com.example.movieticketbookingsystem.service.TheaterService;
import com.example.movieticketbookingsystem.util.ResponseStructure;
import com.example.movieticketbookingsystem.util.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TheaterController {
    private final TheaterService theaterService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/theater")
    public ResponseEntity<ResponseStructure<TheaterResponse>> addTheater(String email, @Valid @RequestBody TheaterRegistrationRequest theaterRegistrationRequest){
        TheaterResponse theaterResponse = theaterService.addTheater(email, theaterRegistrationRequest);
        return responseBuilder.sucess(HttpStatus.OK, "Theater has been successfully created", theaterResponse);
    }
    @GetMapping("theaters/{theaterId}")
    public ResponseEntity<ResponseStructure<TheaterResponse>> findTheater(@PathVariable String theaterId){
        TheaterResponse theaterResponse = theaterService.findTheater(theaterId);
        return responseBuilder.sucess(HttpStatus.OK, "Theater has been sucessfully fetched", theaterResponse);
    }

}