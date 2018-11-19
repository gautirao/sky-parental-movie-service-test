package com.sky.video.streaming.services.exceptions;

public class TitleNotFoundException extends Exception {

    public TitleNotFoundException() {
        super();
    }

    public TitleNotFoundException(String message) {
        super(message);
    }

    public TitleNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public TitleNotFoundException(Throwable cause) {
        super(cause);
    }

    protected TitleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
