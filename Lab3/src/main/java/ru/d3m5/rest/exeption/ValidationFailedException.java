package ru.d3m5.rest.exeption;

public class ValidationFailedException extends Exception {
    public ValidationFailedException(String message){
        super(message);
    }
}
