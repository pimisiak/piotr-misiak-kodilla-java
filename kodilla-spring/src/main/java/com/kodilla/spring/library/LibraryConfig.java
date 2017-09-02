package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LibraryConfig {
    @Bean
    Library library() {
        return new Library(libraryDbController());
    }

    @Bean
    LibraryDbController libraryDbController() {
        return new LibraryDbController();
    }
}
