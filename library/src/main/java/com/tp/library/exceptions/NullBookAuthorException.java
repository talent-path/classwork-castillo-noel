package com.tp.library.exceptions;

public class NullBookAuthorException extends Exception {

    public NullBookAuthorException(String message) {
        super(message);
    }

    public NullBookAuthorException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
