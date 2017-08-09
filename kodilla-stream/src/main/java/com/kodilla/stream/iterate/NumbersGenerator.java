package com.kodilla.stream.iterate;

import java.util.stream.Stream;

public final class NumbersGenerator {
    /**
     * Generates even numbers.
     *
     * @param max Limits the size of the Stream
     */
    public static void generateEven(final int max) {
        Stream.iterate(1, n -> n + 1)
                .limit(max)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
