package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter implements Classifier {
    private final MedianAdaptee medianAdaptee;

    public MedianAdapter(final MedianAdaptee medianAdaptee) {
        this.medianAdaptee = medianAdaptee;
    }

    @Override
    public int publicationYearMedian(final Set<Book> books) {
        final Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> booksInLibraryBFormat = transformToLibraryBFormat(books);
        return medianAdaptee.medianPublicationYear(booksInLibraryBFormat);
    }

    private Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> transformToLibraryBFormat(final Set<Book> books) {
        final Map<BookSignature, com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book> booksInLibraryBFormat = new HashMap<>();
        for (final Book book : books) {
            booksInLibraryBFormat.put(
                    new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return booksInLibraryBFormat;
    }
}
