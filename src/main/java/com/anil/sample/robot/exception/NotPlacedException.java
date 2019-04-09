package com.anil.sample.robot.exception;

public class NotPlacedException extends Exception {

    public NotPlacedException(String message) {
        super(message);
    }

    public NotPlacedException(String message, Throwable cause) {
        super(message, cause);
    }
}
