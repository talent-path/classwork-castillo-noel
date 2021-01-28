package com.tp.connectfour.exceptions;

public class ColunmOutOfBoundsException extends Exception{

    public ColunmOutOfBoundsException(String message){
        super(message);
    }
    public ColunmOutOfBoundsException(String message, Throwable innerException){
        super(message,innerException);
    }
}
