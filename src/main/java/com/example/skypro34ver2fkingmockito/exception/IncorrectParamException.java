package com.example.skypro34ver2fkingmockito.exception;

public class IncorrectParamException extends RuntimeException {
    public IncorrectParamException() {
    }

    public IncorrectParamException(String message) {
        super(message);
    }

    public IncorrectParamException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectParamException(Throwable cause) {
        super(cause);
    }

    public IncorrectParamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
