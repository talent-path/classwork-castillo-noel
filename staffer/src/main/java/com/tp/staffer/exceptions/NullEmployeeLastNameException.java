package com.tp.staffer.exceptions;

public class NullEmployeeLastNameException extends Exception {

    public NullEmployeeLastNameException(String message) {
        super(message);
    }

    public NullEmployeeLastNameException(String message, Throwable innerException) {
        super(message, innerException);
    }
}
