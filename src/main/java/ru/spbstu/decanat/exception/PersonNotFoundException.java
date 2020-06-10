package ru.spbstu.decanat.exception;


public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String message){
        super(message);
    }
}