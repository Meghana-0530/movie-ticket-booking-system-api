
package com.example.movieticketbookingsystem.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class ResponseStructure<T> {
    private int Statuscode;
    private String message;
    private T data;

}
