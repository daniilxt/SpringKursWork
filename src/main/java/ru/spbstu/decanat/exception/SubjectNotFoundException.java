package ru.spbstu.decanat.exception;


public class SubjectNotFoundException extends RuntimeException {
    public SubjectNotFoundException(String message){
        super(message);
    }
}