package org.example.exceptions;

public class NullObjectException extends RuntimeException {
    public NullObjectException() {
    }

    public NullObjectException(String message) {
        super(message);
    }
}
