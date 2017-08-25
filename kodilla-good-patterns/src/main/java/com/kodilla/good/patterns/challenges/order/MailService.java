package com.kodilla.good.patterns.challenges.order;

final class MailService implements InformationService {
    @Override
    public void inform(final User user) {
        System.out.printf("Sending information to %s.%n", user.getEmail());
    }
}
