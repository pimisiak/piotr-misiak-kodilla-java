package com.kodilla.patterns.visitor;

public interface Visitable {
    double accept(final Visitor visitor);
}
