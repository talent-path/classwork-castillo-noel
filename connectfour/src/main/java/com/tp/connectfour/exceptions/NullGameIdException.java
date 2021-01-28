package com.tp.connectfour.exceptions;

public class NullGameIdException extends Exception{

    public NullGameIdException(String message){
        super(message);
    }
    public NullGameIdException(String message, Throwable innerException){
        super(message,innerException);
    }
}
