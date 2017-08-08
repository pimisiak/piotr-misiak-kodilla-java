package com.kodilla.testing.shape;

public class Square implements Shape {
    private static final String name = "Square";
    private final double width;

    Square(final double width) {
        this.width = width;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return width * width;
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
        return Double.compare(square.width, width) == 0;
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
        return String.format("%s - %.2f", getShapeName(), getField());
    }
}
