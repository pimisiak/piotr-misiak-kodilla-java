package com.kodilla.testing.library;

import java.util.List;

/**
 * LibraryDatabase description.
 */
public interface LibraryDatabase {
    /**
     * Description.
     *
     * @param titleFragment desc
     * @return desc
     */
    List<Book> listBooksWithCondition(String titleFragment);

    /**
     * Description.
     *
     * @param libraryUser desc
     * @return desc
     */
    List<Book> listBooksInHandsOf(LibraryUser libraryUser);

    /**
     * Description.
     *
     * @param libraryUser desc
     * @param book desc
     * @return desc
     */
    boolean rentABook(LibraryUser libraryUser, Book book);

    /**
     * Description.
     *
     * @param libraryUser desc
     * @return desc
     */
    int returnBooks(LibraryUser libraryUser);
}
