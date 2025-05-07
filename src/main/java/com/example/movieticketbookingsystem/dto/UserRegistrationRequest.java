package com.example.movieticketbookingsystem.dto;

import lombok.Builder;

@Builder
public record UserRegistrationRequest(
        String username,
        String email,
        String phoneNumber,
        String Password

) {
}