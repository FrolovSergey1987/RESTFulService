package com.example.questiontesting.exception;

public class NoQuestionException extends RuntimeException {
    public NoQuestionException(Long id) {
        super("No question found with current Id " + id );
    }
}
