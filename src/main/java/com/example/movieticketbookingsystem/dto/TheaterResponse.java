package com.example.movieticketbookingsystem.dto;

public record TheaterResponse(
        String theaterId,
        String name,
        String address,
        String city,
        String landmark
)
{}