package com.example.sampleproject.ApiExceptions;

public class ApiEmptyException extends Exception{

    public ApiEmptyException() {
        super("Requested item is empty");
    }

    public ApiEmptyException(String s) {
        super(s);
    }

    public ApiEmptyException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
