package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(final Map<BookSignature, Book> books);
    int medianPublicationYear(final Map<BookSignature, Book> books);
}
