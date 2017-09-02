package com.kodilla.spring.reader;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReaderTestSuite {
    @Test
    public void testRead() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        final Reader reader = context.getBean(Reader.class);
        //When & Then
        reader.read();
    }

    @Test
    public void testConditional() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext(ReaderConfig.class);
        //When
        final boolean book2Exists = context.containsBean("book2");
        //Then
        System.out.printf("Bean book2 was found in the container: %s", book2Exists);
    }
}
