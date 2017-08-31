package com.kodilla.good.patterns.challenges.order;

final class PaymentResult {
    private final boolean isProcessed;
    private final int id;

    PaymentResult(final boolean isProcessed, final int id) {
        this.isProcessed = isProcessed;
        this.id = id;
    }

    boolean isProcessed() {
        return isProcessed;
    }

    int getId() {
        return id;
    }

    String getInformation() {
        if (isProcessed) {
            return String.format("Transaction %d has completed successfully.", id);
        }
        return String.format("Transaction %d has been terminated.", id);
    }
}
