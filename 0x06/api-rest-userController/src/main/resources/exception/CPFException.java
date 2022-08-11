package com.example.user.exception;

public class CPFException extends RuntimeException {
    public CPFException(String cpf) {
        super(cpf);
    }
}
