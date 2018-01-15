package com.kodilla.patterns.visitor;

public class Tabacco implements Visitable {
    private final double price;

    public Tabacco(final double price) {
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
