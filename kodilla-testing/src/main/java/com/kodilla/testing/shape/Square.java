package com.kodilla.testing.shape;

public class Square implements Shape {
    private final String name;
    private final double width;

    public Square(final String name, final double width) {
        this.name = name;
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return getWidth() * getWidth();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return Double.compare(square.width, width) == 0 && name.equals(square.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s - %f", getShapeName(), getField());
    }

    public double getWidth() {
        return width;
    }
}
