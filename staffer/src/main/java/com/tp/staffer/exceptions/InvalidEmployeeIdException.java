package com.tp.staffer.exceptions;

public class InvalidEmployeeIdException extends Exception {

    public InvalidEmployeeIdException(String message) {
        super(message);
    }

    public InvalidEmployeeIdException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
