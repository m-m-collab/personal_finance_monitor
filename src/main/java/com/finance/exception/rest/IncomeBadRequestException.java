package com.finance.exception.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Income Bad Request Exception for REST API.
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncomeBadRequestException extends RuntimeException {

    public IncomeBadRequestException() {
        this("Bad request");
    }

    public IncomeBadRequestException(String message) {
        this(message, (Throwable)null);
    }

    public IncomeBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
