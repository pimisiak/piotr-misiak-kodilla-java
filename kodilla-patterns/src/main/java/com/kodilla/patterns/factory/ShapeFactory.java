package com.kodilla.patterns.factory;

final class ShapeFactory {
    static final String CIRCLE = "CIRCLE";
    static final String SQUARE = "SQUARE";
    static final String RECTANGLE = "RECTANGLE";

    final Shape makeShape(final String shapeClass) {
        switch (shapeClass) {
            case CIRCLE:
                return new Circle("The rounded circle", 4.5);
            case SQUARE:
                return new Square("The angular square", 7);
            case RECTANGLE:
                return new Rectangle("The long rectangle", 15, 2.5);
            default:
                return null;
        }
    }
}
