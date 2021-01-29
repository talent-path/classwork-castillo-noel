package com.tp.library.exceptions;

public class NullBookTitleException extends Exception {

    public NullBookTitleException(String message) {
        super(message);
    }

    public NullBookTitleException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
