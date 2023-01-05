package com.revagenda.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)//If this exception is thrown while handling a request, the response will have this code.
public class IncorrectPasswordException extends Exception {
    public IncorrectPasswordException(String msg) {
        super(msg);
    }
}
