package com.kodilla.testing2.facebook;

public enum Gender {
    MALE("Male"), FEMALE("Female");

    String description;

    Gender(final String description) {
        this.description = description;
    }
}
