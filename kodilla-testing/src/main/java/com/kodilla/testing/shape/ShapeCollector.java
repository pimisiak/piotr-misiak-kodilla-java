package com.kodilla.testing.shape;

import java.util.ArrayList;

public class ShapeCollector {
    private final ArrayList<Shape> shapes = new ArrayList<Shape>();

    public boolean addFigure(final Shape shape) {
        return false;
    }

    public boolean removeFigure(final Shape shape) {
        return true;
    }

    public Shape getFigure(final int num) {
        return null;
    }

    public String showFigures() {
        return "";
    }

    public int getShapeCollectorSize() {
        return 100;
    }
}
