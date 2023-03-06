package com.finance.exception.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Income Not Found Exception for REST API.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class IncomeNotFoundException extends RuntimeException {

        public IncomeNotFoundException() {
            this("Entity Representation Model not found");
        }

        public IncomeNotFoundException(String message) {
            this(message, (Throwable) null);
        }

        public IncomeNotFoundException(String message, Throwable cause) {
            super(message, cause);
        }

}
