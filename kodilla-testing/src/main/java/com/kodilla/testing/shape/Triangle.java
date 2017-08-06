package com.kodilla.testing.shape;

public class Triangle implements Shape {
    private final String name;
    private final double height;
    private final double base;

    public Triangle(final String name, final double height, final double base) {
        this.name = name;
        this.height = height;
        this.base = base;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return 0.5 * getBase() * getHeight();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.height, height) == 0 && Double.compare(triangle.base, base) == 0 && name.equals(triangle.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(height);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(base);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s - %f", getShapeName(), getField());
    }

    public double getHeight() {
        return height;
    }

    public double getBase() {
        return base;
    }
}
