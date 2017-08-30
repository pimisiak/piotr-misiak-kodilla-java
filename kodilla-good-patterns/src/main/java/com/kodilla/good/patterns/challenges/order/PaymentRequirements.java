package com.kodilla.good.patterns.challenges.order;

final class PaymentRequirements {
    private final double payment;
    private final User user;

    PaymentRequirements(final double payment, final User user) {
        this.payment = payment;
        this.user = user;
    }

    double getPayment() {
        return payment;
    }

    User getUser() {
        return user;
    }
}
