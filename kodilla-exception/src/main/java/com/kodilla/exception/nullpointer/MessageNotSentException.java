package com.kodilla.exception.nullpointer;

class MessageNotSentException extends Exception {
    MessageNotSentException(final String message) {
        super(message);
    }
}
