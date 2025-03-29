package com.example.s09_nop_relexsun_sr_spring_hw003.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}
