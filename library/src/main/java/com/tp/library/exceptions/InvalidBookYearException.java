package com.tp.library.exceptions;

public class InvalidBookYearException extends Exception {

    public InvalidBookYearException(String message) {
        super(message);
    }

    public InvalidBookYearException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
