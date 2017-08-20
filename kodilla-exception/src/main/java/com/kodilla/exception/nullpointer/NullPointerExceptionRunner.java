package com.kodilla.exception.nullpointer;

final class NullPointerExceptionRunner {
    public static void main(final String[] args) {
        final User user = null;
        final MessageSender messageSender = new MessageSender();
        try {
            messageSender.sendMessageTo(user, "Hello!");
        } catch (MessageNotSentException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        System.out.println("Processing other logic.");
    }
}
