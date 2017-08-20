package com.kodilla.stream.array;

import com.google.common.base.Preconditions;

import java.util.OptionalDouble;
import java.util.stream.IntStream;

public interface ArrayOperations {
    /**
     * Calculates average of numbers in a table.
     *
     * @param numbers table containing numbers
     * @return average of numbers in a table
     */
    static double getAverage(final int[] numbers) {
        Preconditions.checkNotNull(numbers);
        IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .forEach(System.out::println);
        return IntStream.range(0, numbers.length)
                .map(n -> numbers[n])
                .average()
                .orElse(0);
    }
}
