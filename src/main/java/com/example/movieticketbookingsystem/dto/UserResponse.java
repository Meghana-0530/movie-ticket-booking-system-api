
package com.example.movieticketbookingsystem.dto;

import com.example.movieticketbookingsystem.enums.UserRole;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserResponse<email>(
        String username,
        String email,
        String phoneNumber,
        LocalDate dateOfBirth,
        UserRole userRole
){}
