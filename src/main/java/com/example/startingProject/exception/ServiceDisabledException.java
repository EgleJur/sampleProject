package com.example.startingProject.exception;


public class ServiceDisabledException extends RuntimeException {


    public ServiceDisabledException() {
    }

    public ServiceDisabledException(String message) {
        super(message);
    }

}
