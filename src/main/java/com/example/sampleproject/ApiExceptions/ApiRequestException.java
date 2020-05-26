package com.example.sampleproject.ApiExceptions;

public class ApiRequestException extends Exception{

    public ApiRequestException() {
//        super("Requested item is not found.");
    }

    public ApiRequestException(String s) {
        super(s);
    }

    public ApiRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
