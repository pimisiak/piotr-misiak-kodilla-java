package com.kodilla.spring.forum;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ForumUserTestSuite {
    @Test
    public void testGetUsername() {
        //Given
        final ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");
        final ForumUser user = context.getBean(ForumUser.class);
        //When
        final String result = user.getUsername();
        //Then
        Assert.assertEquals("John Smith", result);
    }
}
