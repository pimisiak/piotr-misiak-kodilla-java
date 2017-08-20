package com.kodilla.exception.nullpointer;

class MessageNotSentException extends Exception {
    public MessageNotSentException(final String message) {
        super(message);
    }
}
