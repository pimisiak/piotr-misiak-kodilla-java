package com.kodilla.patterns.visitor;

public class Neccessity implements Visitable {
    private final double price;

    public Neccessity(final double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public double accept(final Visitor visitor) {
        return visitor.visit(this);
    }
}