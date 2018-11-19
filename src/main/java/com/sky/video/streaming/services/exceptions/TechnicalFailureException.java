package com.sky.video.streaming.services.exceptions;

public class TechnicalFailureException extends Exception {

    public TechnicalFailureException() {
        super();
    }

    public TechnicalFailureException(String message) {
        super(message);
    }

    public TechnicalFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public TechnicalFailureException(Throwable cause) {
        super(cause);
    }

    protected TechnicalFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
