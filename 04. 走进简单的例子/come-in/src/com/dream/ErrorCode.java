package com.dream;

public enum ErrorCode {
    SUCCESS(0),
    ERROR_FATAL(1),
    ERROR_CREDENTIAL(2);

    private final int value;

    ErrorCode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}