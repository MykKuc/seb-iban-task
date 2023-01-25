package com.mykolas.sebibantask.ibanexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectIbanLengthException extends RuntimeException{

    public IncorrectIbanLengthException(String message) {
        super(message);
    }
}
