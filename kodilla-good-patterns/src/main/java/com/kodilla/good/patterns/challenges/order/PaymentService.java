package com.kodilla.good.patterns.challenges.order;

interface PaymentService {
    PaymentResult processPayment(PaymentRequirements paymentRequirements);
}
