package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeClass
    public static void startLogger() {
        logger = Logger.getInstance();
    }

    @Test
    public void testLog() {
        //Given
        //logger
        //When
        logger.log("This is first log.");
        //Then
        Assert.assertEquals("This is first log.", logger.getLastLog());
    }

    @Test
    public void testGetLastLog() {
        //Given
        //logger
        //When
        logger.log("This is second log.");
        final String result = logger.getLastLog();
        //Then
        Assert.assertEquals("This is second log.", result);
    }
}
