package com.kodilla.patterns.visitor;

import org.junit.Assert;
import org.junit.Test;

public class VisitorTestSuite {
    @Test
    public void testVisitor() {
        //Given
        final Visitor visitor = new TaxVisitor();
        final Liquor jackDaniels = new Liquor(45.23);
        final Tabacco marlboro = new Tabacco(11.23);
        final Neccessity milk = new Neccessity(4.23);
        //When
        final double taxedJackDaniels = jackDaniels.accept(visitor);
        final double taxedMarlboro = marlboro.accept(visitor);
        final double taxedMilk = milk.accept(visitor);
        //Then
        Assert.assertEquals(58.79, taxedJackDaniels, 0.1);
        Assert.assertEquals(12.57, taxedMarlboro, 0.01);
        Assert.assertEquals(5.2, taxedMilk, 0.01);
    }
}
