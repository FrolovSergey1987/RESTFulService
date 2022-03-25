package com.example.questiontesting.exception;

public class WrongLevelException extends RuntimeException {
    public WrongLevelException(Long id) {
        super("Have not level with current id " + id );
    }
}
