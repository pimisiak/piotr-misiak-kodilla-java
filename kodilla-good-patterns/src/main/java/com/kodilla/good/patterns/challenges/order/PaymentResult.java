package com.kodilla.good.patterns.challenges.order;

class PaymentResult implements Information {
    private final boolean isProcessed;

    PaymentResult(final boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    @Override
    public String getInformation() {
        if (isProcessed) {
            return "Payment has completed successfully.";
        }
        return "Payment has been terminated.";
    }
}
