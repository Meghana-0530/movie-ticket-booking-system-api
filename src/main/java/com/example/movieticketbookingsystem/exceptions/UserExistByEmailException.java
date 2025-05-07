
package com.example.movieticketbookingsystem.exceptions;

import lombok.Getter;

@Getter
public class UserExistByEmailException extends RuntimeException{
    private String message;
    public UserExistByEmailException(String messsage){
        this.message = message;
    }
}
