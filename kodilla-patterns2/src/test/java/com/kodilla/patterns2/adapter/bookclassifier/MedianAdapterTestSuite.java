package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void testPublicationYearMedian() {
        //Given
        final Set<Book> books = prepareTestSetOfBooks();
        final MedianAdapter medianAdapter = new MedianAdapter();
        //When
        final int result = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(1955, result);
    }

    private Set<Book> prepareTestSetOfBooks() {
        final Set<Book> books = new HashSet<>();
        for (int i = 1; i < 11; i++) {
            books.add(new Book.Builder()
                    .author("Author" + i)
                    .signature("Signature" + i)
                    .title("Title" + i)
                    .publicationYear(1950 + i)
                    .build());
        }
        return books;
    }
}
