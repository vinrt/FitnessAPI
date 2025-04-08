package com.vinrt.fitnessapp.exceptionhandler;

public class ResourceFoundException extends RuntimeException {
    public ResourceFoundException(String message) {
        super(message);
    }
}
