package com.kodilla.spring.reader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
class ReaderConfig {
    @Autowired
    @Qualifier("book1")
    Book book;

    @Bean
    Reader getReader() {
        return new Reader(book);
    }

    @Bean(name = "book1")
    @Scope("prototype")
    Book getBookOne() {
        return new Book("The book number one");
    }

    @Bean(name = "book2")
    @Scope("prototype")
    @Conditional(IfDayIsOddCondition.class)
    Book getBookTwo() {
        return new Book("The book number two");
    }
}
