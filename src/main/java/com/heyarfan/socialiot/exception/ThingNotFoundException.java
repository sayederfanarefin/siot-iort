package com.heyarfan.socialiot.exception;

public final class ThingNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public ThingNotFoundException() {
        super();
    }

    public ThingNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ThingNotFoundException(final String message) {
        super(message);
    }

    public ThingNotFoundException(final Throwable cause) {
        super(cause);
    }

}
