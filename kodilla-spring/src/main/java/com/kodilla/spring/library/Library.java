package com.kodilla.spring.library;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
final class Library {
    private final List<String> books = new ArrayList<>();
    private LibraryDbController libraryDbController;

    public Library(final LibraryDbController libraryDbController) {
        this.libraryDbController = libraryDbController;
    }

    public Library() {
    }

    void saveToDb() {
        libraryDbController.saveData();
    }

    void loadFromDb() {
        libraryDbController.loadData();
    }
}
