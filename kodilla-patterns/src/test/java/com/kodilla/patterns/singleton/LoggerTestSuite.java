package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class LoggerTestSuite {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    @Test
    public void testLog() {
        //Given
        systemOutRule.enableLog();
        //When
        Logger.getInstance().log("This is first log.");
        //Then
        Assert.assertEquals("Log: [This is first log.]\n", systemOutRule.getLogWithNormalizedLineSeparator());
    }

    @Test
    public void testGetLastLog() {
        //Given
        //logger
        //When
        Logger.getInstance().log("This is second log.");
        //Then
        Assert.assertEquals("This is second log.", Logger.getInstance().getLastLog());
    }
}
