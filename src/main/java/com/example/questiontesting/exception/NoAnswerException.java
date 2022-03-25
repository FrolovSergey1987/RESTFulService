package com.example.questiontesting.exception;

public class NoAnswerException extends RuntimeException {
    public NoAnswerException(Long id) {
        super("No answer found with current Id " + id );
    }
}
