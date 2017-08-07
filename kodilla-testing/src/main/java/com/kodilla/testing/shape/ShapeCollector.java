package com.kodilla.testing.shape;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.StringJoiner;

public class ShapeCollector {
    private final ArrayList<Shape> shapes = new ArrayList<Shape>();

    public void addFigure(final Shape shape) {
        Preconditions.checkNotNull(shape);
        shapes.add(shape);
    }

    public boolean removeFigure(final Shape shape) {
        Preconditions.checkNotNull(shape);
        return shapes.remove(shape);
    }

    public Shape getFigure(final int num) {
        Preconditions.checkArgument(num >= 0 && num < getShapeCollectorSize());
        return shapes.get(num);
    }

    public String showFigures() {
        final StringJoiner joiner = new StringJoiner("; ");
        for (Shape shape : shapes) {
            joiner.add(shape.toString());
        }
        return joiner.toString();
    }

    public int getShapeCollectorSize() {
        return shapes.size();
    }
}
