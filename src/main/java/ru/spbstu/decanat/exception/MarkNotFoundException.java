package ru.spbstu.decanat.exception;


public class MarkNotFoundException extends RuntimeException {
    public MarkNotFoundException(String message){
        super(message);
    }
}