package org.example.exceptions;

public class NullItemException extends RuntimeException {
    public NullItemException() {
    }

    public NullItemException(String message) {
        super(message);
    }
}
