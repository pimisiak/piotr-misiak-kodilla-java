package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class Library {
    @Autowired
    private LibraryDbController libraryDbController;

    void saveToDb() {
        libraryDbController.saveData();
    }

    void loadFromDb() {
        libraryDbController.loadData();
    }
}
