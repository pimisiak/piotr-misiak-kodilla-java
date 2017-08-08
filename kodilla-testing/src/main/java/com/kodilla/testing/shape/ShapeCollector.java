package com.kodilla.testing.shape;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class ShapeCollector {
    private final List<Shape> shapes = new ArrayList<Shape>();

    void addFigure(final Shape shape) {
        Preconditions.checkNotNull(shape);
        shapes.add(shape);
    }

    boolean removeFigure(final Shape shape) {
        Preconditions.checkNotNull(shape);
        return shapes.remove(shape);
    }

    Shape getFigure(final int num) {
        Preconditions.checkArgument(num >= 0 && num < size());
        return shapes.get(num);
    }

    String showFigures() {
        final StringJoiner joiner = new StringJoiner("; ");
        for (Shape shape : shapes) {
            joiner.add(shape.toString());
        }
        return joiner.toString();
    }

    int size() {
        return shapes.size();
    }
}
