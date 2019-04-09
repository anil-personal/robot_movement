package com.anil.sample.robot.exception;

/**
 * Application exception for unable to move in specific direction.
 */
public class CanNotMoveException extends Exception{

    public CanNotMoveException(String message) {
        super(message);
    }

    public CanNotMoveException(String message, Throwable cause) {
        super(message, cause);
    }
}
