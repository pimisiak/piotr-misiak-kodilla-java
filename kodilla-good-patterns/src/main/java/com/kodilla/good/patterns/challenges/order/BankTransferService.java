package com.kodilla.good.patterns.challenges.order;

final class BankTransferService implements PaymentService {
    @Override
    public boolean processPayment(final double payment) {
        System.out.printf("Processing payment %.2f with bank transfer.%n", payment);
        return true;
    }
}
