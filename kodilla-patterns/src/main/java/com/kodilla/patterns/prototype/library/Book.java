package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;

final class Book {
    private final String title;
    private final String author;
    private final LocalDate publicationDate;

    Book(final String title, final String author, final LocalDate publicationDate) {
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    Book(final Book book) {
        this.title = book.title;
        this.author = book.author;
        this.publicationDate = book.publicationDate;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    LocalDate getPublicationDate() {
        return publicationDate;
    }

    @Override
    public String toString() {
        return String.format("Book{title='%s', author='%s', publicationDate=%s}", title, author, publicationDate);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Book book = (Book) o;
        return title.equals(book.title) && author.equals(book.author) && publicationDate.equals(book.publicationDate);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + publicationDate.hashCode();
        return result;
    }
}