package com.alexshay.task2.servise.exception;

public class ServiseException extends Exception {
    public ServiseException() {
        super();
    }

    public ServiseException(String message) {
        super(message);
    }

    public ServiseException(String message, Exception e) {
        super(message, e);
    }
}
