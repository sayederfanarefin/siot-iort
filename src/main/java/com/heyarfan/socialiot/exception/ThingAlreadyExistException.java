package com.heyarfan.socialiot.exception;

public final class ThingAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public ThingAlreadyExistException() {
        super();
    }

    public ThingAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ThingAlreadyExistException(final String message) {
        super(message);
    }

    public ThingAlreadyExistException(final Throwable cause) {
        super(cause);
    }

}
