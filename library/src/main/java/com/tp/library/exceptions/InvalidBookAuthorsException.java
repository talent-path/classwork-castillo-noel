package com.tp.library.exceptions;

public class InvalidBookAuthorsException extends Exception {

    public InvalidBookAuthorsException(String message) {
        super(message);
    }

    public InvalidBookAuthorsException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
