package com.tp.connectfour.exceptions;

public class NullColumnException extends Exception{

    public NullColumnException(String message){
        super(message);
    }
    public NullColumnException(String message, Throwable innerException){
        super(message,innerException);
    }
}
