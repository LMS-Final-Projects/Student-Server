package com.example.student.global.exception;

import lombok.Getter;

@Getter
public class MethodException extends RuntimeException{
    public MethodException(String message) {
        super(message);
    }

}
