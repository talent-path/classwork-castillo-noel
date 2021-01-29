package com.tp.library.exceptions;

public class NullBookYearException extends Exception {

    public NullBookYearException(String message) {
        super(message);
    }

    public NullBookYearException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
