package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class MovieStore {
    private final Map<String, List<String>> store = new HashMap<>();

    Map<String, List<String>> getStore() {
        return Collections.unmodifiableMap(store);
    }

    void addMovie(final String signature, final List<String> translations) {
        store.put(signature, new ArrayList<>(translations));
    }
}