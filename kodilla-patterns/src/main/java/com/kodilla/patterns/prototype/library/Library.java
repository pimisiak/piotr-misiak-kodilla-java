package com.kodilla.patterns.prototype.library;

import java.util.HashSet;
import java.util.Set;

final class Library extends Prototype {
    private final String name;
    private Set<Book> books = new HashSet<>();

    Library(final String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    Set<Book> getBooks() {
        return books;
    }

    void addBook(final Book book) {
        books.add(book);
    }

    boolean removeBook(final Book book) {
        return books.remove(book);
    }

    Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    Library deepCopy() throws CloneNotSupportedException {
        final Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book book : books) {
            final Book clonedBook = new Book(book);
            clonedLibrary.books.add(clonedBook);
        }
        return clonedLibrary;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Library library = (Library) o;
        return name.equals(library.name) && books.equals(library.books);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + books.hashCode();
        return result;
    }
}