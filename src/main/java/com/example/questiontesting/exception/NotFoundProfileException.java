package com.example.questiontesting.exception;

public class NotFoundProfileException extends RuntimeException {
    public NotFoundProfileException(Long id) {
        super("Not Found Profile with current Id " + id );
    }
}
