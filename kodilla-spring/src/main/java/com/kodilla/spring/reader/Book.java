package com.kodilla.spring.reader;

final class Book {
    private final String title;

    Book(final String title) {
        this.title = title;
    }

    String getTitle() {
        return title;
    }
}
