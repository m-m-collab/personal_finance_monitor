package com.finance.exception.utils;

/**
 * File utils Exception.
 */
public class FileUtilsException extends RuntimeException {

    public FileUtilsException() {
        this("Can not execute that file");
    }

    public FileUtilsException(String message) {
        this(message, (Throwable) null);
    }

    public FileUtilsException(String message, Throwable cause) {
        super(message, cause);
    }

}
