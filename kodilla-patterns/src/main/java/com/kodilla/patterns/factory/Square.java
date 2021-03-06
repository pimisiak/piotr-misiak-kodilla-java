package com.kodilla.patterns.factory;

final class Square implements Shape {
    private final String name;
    private final double width;

    Square(final String name, final double width) {
        this.name = name;
        this.width = width;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.pow(width, 2.0);
    }

    @Override
    public double getCircumference() {
        return 4 * width;
    }
}
