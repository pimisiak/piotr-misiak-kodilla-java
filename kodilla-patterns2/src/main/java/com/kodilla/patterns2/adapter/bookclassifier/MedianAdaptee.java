package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookSignature;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatistics;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.BookStatisticsImpl;

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
