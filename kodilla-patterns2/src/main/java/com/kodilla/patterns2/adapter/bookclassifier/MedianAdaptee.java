package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclassifier.libraryb.BookStatisticsImpl;

import java.util.Map;

public class MedianAdaptee implements BookStatistics {
    @Override
    public int medianPublicationYear(final Map<BookSignature, Book> books) {
        return new BookStatisticsImpl().medianPublicationYear(books);
    }

    @Override
    public int averagePublicationYear(final Map<BookSignature, Book> books) {
        return new BookStatisticsImpl().averagePublicationYear(books);
    }
}
