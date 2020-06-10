package ru.spbstu.decanat.exception;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(String message){
        super(message);
    }
}