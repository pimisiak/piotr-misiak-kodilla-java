package com.kodilla.good.patterns.challenges.order;

final class BankTransferService implements PaymentService {
    @Override
    public PaymentResult processPayment(final PaymentRequirements paymentRequirements) {
        System.out.printf("Processing payment %.2f with bank transfer.%n", paymentRequirements.getPayment());
        return new PaymentResult(true);
    }
}
