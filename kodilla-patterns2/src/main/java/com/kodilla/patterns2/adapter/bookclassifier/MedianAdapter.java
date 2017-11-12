package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(final Set<Book> books) {
        final Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> booksInLibraryBFormat = transformToLibraryBFormat(books);
        return new MedianAdaptee().medianPublicationYear(booksInLibraryBFormat);
    }

    private Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> transformToLibraryBFormat(final Set<Book> books) {
        final Map<BookSignature, com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book> booksInLibraryBFormat = new HashMap<>();
        for (final Book book : books) {
            booksInLibraryBFormat.put(
                    new BookSignature(book.getSignature()),
                    new com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book(book.getAuthor(), book.getTitle(), book.getPublicationYear()));
        }
        return booksInLibraryBFormat;
    }
}
