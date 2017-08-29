package com.kodilla.good.patterns.challenges.order;

interface Order extends Information {
    double orderPrice();
    void addProduct(final Product product, final int quantity);
    int getId();
    User getUser();
}
