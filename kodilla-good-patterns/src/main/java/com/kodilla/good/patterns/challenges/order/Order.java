package com.kodilla.good.patterns.challenges.order;

interface Order extends Information {
    double orderPrice();
    int getId();
    User getUser();
}
