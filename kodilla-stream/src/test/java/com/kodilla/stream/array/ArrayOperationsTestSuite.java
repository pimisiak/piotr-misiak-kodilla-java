package com.kodilla.stream.array;

import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        final int[] numbers = IntStream.range(1, 11).toArray();
        //When
        final double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(5.5, average, 0.01);
    }
}
