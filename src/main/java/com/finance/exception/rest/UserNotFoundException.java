package com.finance.exception.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * AppUser Not Found Exception for REST API.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        this("Entity Representation Model not found");
    }

    public UserNotFoundException(String message) {
        this(message, (Throwable) null);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
