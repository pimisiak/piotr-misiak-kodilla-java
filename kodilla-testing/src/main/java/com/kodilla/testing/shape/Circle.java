package com.kodilla.testing.shape;

public class Circle implements Shape {
    private final String name;
    private final double radius;

    public Circle(final String name, final double radius) {
        this.name = name;
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return name;
    }

    @Override
    public double getField() {
        return Math.PI * getRadius() * getRadius();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && name.equals(circle.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s - %f", getShapeName(), getField());
    }

    public double getRadius() {
        return radius;
    }
}