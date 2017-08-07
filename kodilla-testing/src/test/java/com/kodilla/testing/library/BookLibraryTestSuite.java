package com.kodilla.testing.library;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookLibraryTestSuite {
    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;

    @Before
    public void before() {
        libraryDatabaseMock = mock(LibraryDatabase.class);
        bookLibrary = new BookLibrary(libraryDatabaseMock);
    }

    @Test
    public void testListBooksWithConditionReturnList() {
        // Given
        final List<Book> resultListOfBooks = new ArrayList<Book>();
        final Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        final Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        final Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        final Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);
        // When
        final List<Book> listOfBooks = bookLibrary.listBooksWithCondition("Secret");
        // Then
        assertEquals(4, listOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        final List<Book> resultListOf0Books = new ArrayList<Book>();
        final List<Book> resultListOf15Books = generateListOfNBooks(15);
        final List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks")).thenReturn(resultListOf40Books);
        // When
        final List<Book> listOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        final List<Book> listOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        final List<Book> listOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then
        assertEquals(0, listOfBooks0.size());
        assertEquals(15, listOfBooks15.size());
        assertEquals(0, listOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        final List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf10Books);
        // When
        final List<Book> listOfBooks10 = bookLibrary.listBooksWithCondition("An");
        // Then
        assertEquals(0, listOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListBooksInHandsOfNoBooks() {
        // Given
        final List<Book> resultListOf0Books = new ArrayList<>();
        final LibraryUser libraryUser = new LibraryUser("Rick", "Sanchez", "77010112345");
        when(libraryDatabaseMock.listBooksInHandsOf(any())).thenReturn(resultListOf0Books);
        // When
        final List<Book> listOfNoBooks = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(0, listOfNoBooks.size());
    }

    @Test
    public void testListBooksInHandsOfOneBook() {
        // Given
        final List<Book> resultListOf0Books = generateListOfNBooks(1);
        final LibraryUser libraryUser = new LibraryUser("Morty", "Smith", "96011212345");
        when(libraryDatabaseMock.listBooksInHandsOf(any())).thenReturn(resultListOf0Books);
        // When
        final List<Book> listOfNoBooks = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(1, listOfNoBooks.size());
    }

    @Test
    public void testListBooksInHandsOf5Books() {
        // Given
        final List<Book> resultListOf0Books = generateListOfNBooks(5);
        final LibraryUser libraryUser = new LibraryUser("Summer", "Smith", "94011212345");
        when(libraryDatabaseMock.listBooksInHandsOf(any())).thenReturn(resultListOf0Books);
        // When
        final List<Book> listOfNoBooks = bookLibrary.listBooksInHandsOf(libraryUser);
        // Then
        assertEquals(5, listOfNoBooks.size());
    }

    private List<Book> generateListOfNBooks(final int booksQuantity) {
        final List<Book> resultList = new ArrayList<Book>();
        for (int n = 1; n <= booksQuantity; n++) {
            Book book = new Book("Title" + n, "Author" + n, 1970 +n);
            resultList.add(book);
        }
        return resultList;
    }
}
