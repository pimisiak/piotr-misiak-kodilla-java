package com.kodilla.good.patterns.challenges.order;

final class BankTransferService implements PaymentService {
    @Override
    public PaymentResult processPayment(final PaymentRequirements paymentRequirements) {
        System.out.printf("Processing payment %.2f with bank transfer for account %s.%n",
                paymentRequirements.getPayment(),
                paymentRequirements.getUser().getBankAccountNumber());
        return new PaymentResult(true, paymentRequirements.getUser());
    }
}
