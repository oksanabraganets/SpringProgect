package com.example.simple.exception;

public class TransferParameterException extends Exception {
    public TransferParameterException(String message){
        super(message);
    }

    public TransferParameterException(){
        super("Wrong parameter of money transfer.");
    }
}
