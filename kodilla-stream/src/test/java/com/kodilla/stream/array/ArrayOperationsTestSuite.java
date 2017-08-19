package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage() {
        //Given
        final int[] numbers = prepareTestNumbers();
        //When
        final double average = ArrayOperations.getAverage(numbers);
        //Then
        Assert.assertEquals(5.5, average, 0.01);
    }

    private int[] prepareTestNumbers() {
        final int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        return numbers;
    }
}
