package com.kodilla.patterns.visitor;

public class TaxVisitor implements Visitor {

    @Override
    public double visit(final Neccessity neccessity) {
        return neccessity.getPrice() * 1.23;
    }

    @Override
    public double visit(final Tabacco tabacco) {
        return tabacco.getPrice() + 1.34;
    }

    @Override
    public double visit(final Liquor liquor) {
        return liquor.getPrice() * 1.3;
    }
}
