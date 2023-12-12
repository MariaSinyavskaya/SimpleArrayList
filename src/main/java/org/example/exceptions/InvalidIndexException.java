package org.example.exceptions;

public class InvalidIndexException extends RuntimeException {
    public InvalidIndexException() {
    }

    public InvalidIndexException(String message) {
        super(message);
    }
}
