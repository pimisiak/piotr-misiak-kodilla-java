package com.kodilla.good.patterns.challenges.order;

final class BankTransferService implements PaymentService {
    private static int transactionId;

    @Override
    public PaymentResult processPayment(final PaymentRequirements paymentRequirements) {
        System.out.printf("Processing transaction %d for payment %.2f with bank transfer for account %s.%n",
                ++transactionId,
                paymentRequirements.getPayment(),
                paymentRequirements.getUser().getBankAccountNumber());
        return new PaymentResult(true, transactionId);
    }
}
