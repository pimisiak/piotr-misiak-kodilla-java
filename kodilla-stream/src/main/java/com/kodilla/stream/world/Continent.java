package com.kodilla.stream.world;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

final class Continent {
    private final String name;
    private final Set<Country> countries = new HashSet<>();

    Continent(final String name) {
        this.name = name;
    }

    void addCountry(final Country country) {
        countries.add(country);
    }

    String getName() {
        return name;
    }

    Set<Country> getCountries() {
        return Collections.unmodifiableSet(countries);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Continent continent = (Continent) o;
        return name.equals(continent.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
