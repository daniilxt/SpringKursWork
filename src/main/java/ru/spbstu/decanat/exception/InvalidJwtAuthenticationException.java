package ru.spbstu.decanat.exception;

public class InvalidJwtAuthenticationException extends  RuntimeException {
    public InvalidJwtAuthenticationException(String message){
        super(message);
    }
}
