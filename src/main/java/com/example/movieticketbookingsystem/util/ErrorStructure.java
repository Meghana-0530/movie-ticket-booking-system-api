package com.example.movieticketbookingsystem.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
    public class ErrorStructure {
        private int statuscode;
        @JsonProperty(namespace = "error_message")
        private String errorMessage;

    }

