package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    private Library library;

    @Before
    public void beforeTest() {
        library = new Library("Library 1");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .mapToObj(n -> new Book(String.format("Title%s", n), String.format("Author%s", n), LocalDate.now().minusDays(n)))
                .forEach(library::addBook);
    }

    @Test
    public void testShallowCopy() throws CloneNotSupportedException {
        //Given
        //library
        //When
        final Library clonedLibrary = library.shallowCopy();
        library.removeBook(new Book("Title1", "Author1", LocalDate.now().minusDays(1)));
        //Then
        Assert.assertEquals(clonedLibrary, library);
        Assert.assertEquals(9, clonedLibrary.getBooks().size());
        Assert.assertEquals(9, library.getBooks().size());
    }

    @Test
    public void testDeepCopy() throws CloneNotSupportedException {
        //Given
        //library
        //When
        final Library clonedLibrary = library.deepCopy();
        library.removeBook(new Book("Title1", "Author1", LocalDate.now().minusDays(1)));
        //Then
        Assert.assertNotEquals(clonedLibrary, library);
        Assert.assertEquals(10, clonedLibrary.getBooks().size());
        Assert.assertEquals(9, library.getBooks().size());
    }
}
