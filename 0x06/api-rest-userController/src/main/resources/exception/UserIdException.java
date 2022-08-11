package com.example.user.exception;

public class UserIdException extends RuntimeException {
    public UserIdException(int id) {
        super(String.valueOf(id));
    }
}
