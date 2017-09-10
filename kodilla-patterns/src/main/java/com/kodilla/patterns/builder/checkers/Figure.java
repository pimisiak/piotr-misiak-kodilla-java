package com.kodilla.patterns.builder.checkers;

class Figure {
    static final String WHITE = "WHITE";
    static final String BLACK = "BLACK";
    private final String color;

    Figure(final String color) {
        if (color.equals(WHITE) || color.equals(BLACK)) {
            this.color = color;
        } else {
            throw new IllegalStateException("Figures of checkers should be BLACK or WHITE.");
        }
    }

    String getColor() {
        return color;
    }
}
