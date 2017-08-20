package com.kodilla.exception.nullpointer;

final class MessageSender {
    void sendMessageTo(final User user, final String message) throws MessageNotSentException {
        if (user != null) {
            System.out.println("Sending message: " + message + " to " + user.getName());
            return;
        }
        throw new MessageNotSentException("Object User was null");
    }
}
