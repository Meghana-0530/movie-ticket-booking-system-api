package com.example.movieticketbookingsystem.exceptions;

import lombok.Getter;

@Getter
    public class UserExistsByEmailException extends RuntimeException{
        private String message;
        public UserExistsByEmailException(String messsage) {
            this.message = message;
        }
    }

