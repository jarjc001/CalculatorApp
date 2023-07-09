package org.Calculator.dto;

public class CurrentInputError extends Exception{
    public CurrentInputError (String message){
        super(message);
    }
    public CurrentInputError(String message, Throwable cause){
        super(message, cause);
    }
}
