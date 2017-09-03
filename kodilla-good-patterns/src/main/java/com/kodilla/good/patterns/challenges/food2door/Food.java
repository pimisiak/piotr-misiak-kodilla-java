package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDate;

interface Food extends Product {
    FoodType getFoodType();
    int getCalories();
    LocalDate getExpiringDate();
}
