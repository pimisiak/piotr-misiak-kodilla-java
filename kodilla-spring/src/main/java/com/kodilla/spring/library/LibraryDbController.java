package com.kodilla.spring.library;

import org.springframework.stereotype.Repository;

@Repository
class LibraryDbController {
    void saveData() {
        System.out.println("Saving data to the database.");
    }

    void loadData() {
        System.out.println("Loading data from the database");
    }
}
