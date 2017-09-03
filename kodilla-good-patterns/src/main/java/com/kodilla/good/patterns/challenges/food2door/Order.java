package com.kodilla.good.patterns.challenges.food2door;

import java.util.Map;

interface Order {
    double orderPrice();
    int getId();
    User getUser();
    Map<Food, Integer> getProducts();
}