package com.kodilla.testing.loop;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoopAndConditionalBreakpointsTest {
    @Test
    public void testLoop() {
        //Given
        long sum = 0;
        //When
        for (int n = 0; n < 1000; n++) {
            sum += n;
            System.out.println(String.format("[ %d ] sum equals: %d", n, sum));
        }
        //Then
        assertEquals(499500, sum);
    }
}
