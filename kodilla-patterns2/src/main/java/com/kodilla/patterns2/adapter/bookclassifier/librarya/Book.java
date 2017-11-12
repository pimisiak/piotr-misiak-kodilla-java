package com.kodilla.patterns2.adapter.bookclassifier.librarya;

public class Book {
    private final String author;
    private final String title;
    private final int publicationYear;
    private final String signature;

    private Book(final Builder builder) {
        this.author = builder.author;
        this.title = builder.title;
        this.publicationYear = builder.publicationYear;
        this.signature = builder.signature;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String getSignature() {
        return signature;
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
        return signature.equals(book.signature);
    }

    @Override
    public int hashCode() {
        return signature.hashCode();
    }

    @Override
    public String toString() {
        return String.format("Book{author='%s', title='%s', publicationYear=%d, signature='%s'}", author, title, publicationYear, signature);
    }

    public static class Builder {
        private String author;
        private String title;
        private int publicationYear;
        private String signature;

        public Builder author(final String author) {
            this.author = author;
            return this;
        }

        public Builder title(final String title) {
            this.title = title;
            return this;
        }

        public Builder publicationYear(final int publicationYear) {
            this.publicationYear = publicationYear;
            return this;
        }

        public Builder signature(final String signature) {
            this.signature = signature;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
