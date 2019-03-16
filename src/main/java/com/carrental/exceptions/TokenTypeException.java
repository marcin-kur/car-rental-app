package com.carrental.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TokenTypeException extends RuntimeException {
    public TokenTypeException(String message) {
        super(message);
    }
}
