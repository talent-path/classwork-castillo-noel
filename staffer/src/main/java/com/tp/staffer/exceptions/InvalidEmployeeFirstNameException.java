package com.tp.staffer.exceptions;

public class InvalidEmployeeFirstNameException extends Exception {

    public InvalidEmployeeFirstNameException(String message) {
        super(message);
    }

    public InvalidEmployeeFirstNameException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
