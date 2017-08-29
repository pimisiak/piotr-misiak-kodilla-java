package com.kodilla.good.patterns.challenges.order;

final class MailService implements InformationService {
    @Override
    public void inform(final User user, final Information message) {
        System.out.printf("Sending information to %s.%n", user.getEmail());
        System.out.printf("Message: %s", message.getInformation());
    }
}
