package com.kodilla.exception.index;

import java.util.List;

final class IndexExceptionRunner {
    public static void main(final String[] args) {
        final VideoCollector videoCollector = new VideoCollector();
        final List<String> collection = videoCollector.getCollection();
        if (collection.size() >= 2) {
            final String movie0 = collection.get(0);
            System.out.println(movie0);
            final String movie1 = collection.get(1);
            System.out.println(movie1);
        }
    }
}
