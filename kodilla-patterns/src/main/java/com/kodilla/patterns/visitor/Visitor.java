package com.kodilla.patterns.visitor;

public interface Visitor {
    double visit(final Neccessity neccessity);
    double visit(final Tabacco tabacco);
    double visit(final Liquor liquor);
}
