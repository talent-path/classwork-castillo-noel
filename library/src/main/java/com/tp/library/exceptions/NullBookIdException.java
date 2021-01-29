package com.tp.library.exceptions;

public class NullBookIdException extends Exception {

    public NullBookIdException(String message) {
        super(message);
    }

    public NullBookIdException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
