package org.amazon.exception;

public class DealAlreadyUsedException extends Exception{
    public DealAlreadyUsedException(String message) {
        super(message);
    }
}
