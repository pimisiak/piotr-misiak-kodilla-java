package com.kodilla.good.patterns.challenges.order;

final class PaymentResult implements Information {
    private final boolean isProcessed;
    private final User user;

    PaymentResult(final boolean isProcessed, final User user) {
        this.isProcessed = isProcessed;
        this.user = user;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public String getInformation() {
        if (isProcessed) {
            return "Payment has completed successfully.";
        }
        return "Payment has been terminated.";
    }
}
