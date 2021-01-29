package com.tp.library.exceptions;

public class InvalidBookTitleException extends Exception {

    public InvalidBookTitleException(String message) {
        super(message);
    }

    public InvalidBookTitleException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
