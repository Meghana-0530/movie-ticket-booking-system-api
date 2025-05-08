package com.example.movieticketbookingsystem.service;

import com.example.movieticketbookingsystem.dto.TheaterRegistrationRequest;
import com.example.movieticketbookingsystem.dto.TheaterResponse;

public interface TheaterService {
    TheaterResponse addTheater(String email, TheaterRegistrationRequest theaterRegisterationRequest);

}