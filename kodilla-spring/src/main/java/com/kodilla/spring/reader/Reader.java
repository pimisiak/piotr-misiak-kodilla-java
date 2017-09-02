package com.kodilla.spring.reader;

final class Reader {
    private final Book book;

    Reader(final Book book) {
        this.book = book;
    }

    void read() {
        System.out.printf("Reading: %s", book.getTitle());
    }
}
