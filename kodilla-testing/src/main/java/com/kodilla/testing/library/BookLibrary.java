package com.kodilla.testing.library;

import com.google.common.base.Preconditions;

import java.util.Collections;
import java.util.List;

class BookLibrary {
    private LibraryDatabase libraryDatabase;

    BookLibrary(final LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    List<Book> listBooksWithCondition(final String titleFragment) {
        if (titleFragment.length() < 3) {
            return Collections.emptyList();
        }
        final List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) {
            return Collections.emptyList();
        }
        return resultList;
    }

    List<Book> listBooksInHandsOf(final LibraryUser libraryUser) {
        Preconditions.checkNotNull(libraryUser);
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }
}
