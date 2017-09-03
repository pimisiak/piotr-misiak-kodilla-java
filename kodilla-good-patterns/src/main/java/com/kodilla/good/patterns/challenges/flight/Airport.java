package com.kodilla.good.patterns.challenges.flight;

final class Airport {
    private final String code;
    private final String name;

    Airport(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    String getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Airport airport = (Airport) o;
        return code.equals(airport.code) && name.equals(airport.name);
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return code;
    }
}
