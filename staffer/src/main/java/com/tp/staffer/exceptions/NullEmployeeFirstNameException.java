package com.tp.staffer.exceptions;

public class NullEmployeeFirstNameException extends Exception {

    public NullEmployeeFirstNameException(String message) {
        super(message);
    }

    public NullEmployeeFirstNameException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
