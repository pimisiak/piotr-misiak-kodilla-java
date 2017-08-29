package com.kodilla.good.patterns.challenges.order;

final class Book implements Product {
    private final int id;
    private final double price;
    private final String title;
    private final String author;
    private final int yearOfPublication;

    private Book(final BookBuilder bookBuilder) {
        this.id = bookBuilder.id;
        this.price = bookBuilder.price;
        this.title = bookBuilder.title;
        this.author = bookBuilder.author;
        this.yearOfPublication = bookBuilder.yearOfPublication;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", price=" + price + ", title='" + title + '\'' + ", author='" + author + '\'' + ", yearOfPublication="
                + yearOfPublication + '}';
    }

    @Override
    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    static class BookBuilder {
        private final int id;
        private double price;
        private String title;
        private String author;
        private int yearOfPublication;

        BookBuilder(final int id) {
            this.id = id;
        }

        BookBuilder price(final double price) {
            this.price = price;
            return this;
        }

        BookBuilder title(final String title) {
            this.title = title;
            return this;
        }

        BookBuilder author(final String author) {
            this.author = author;
            return this;
        }

        BookBuilder yearOfPublication(final int yearOfPublication) {
            this.yearOfPublication = yearOfPublication;
            return this;
        }

        Book build() {
            return new Book(this);
        }
    }
}
