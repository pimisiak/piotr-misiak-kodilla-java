package com.kodilla.patterns2.decorator.taxiportal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.math.BigDecimal;

public class TaxiOrderTestSuite {
    @Test
    public void testBasicTaxiOrderGetCost() {
        // Given
        final TaxiOrder order = new BasicTaxiOrder();
        // When
        final BigDecimal calculatedCost = order.getCost();
        // Then
        assertEquals(new BigDecimal(5), calculatedCost);
    }

    @Test
    public void testBasicTaxiOrderGetDescription() {
        // Given
        final TaxiOrder order = new BasicTaxiOrder();
        // When
        final String description = order.getDescription();
        // Then
        assertEquals("Drive a course", description);
    }

    @Test
    public void testMyTaxiWithChildSeatGetCost() {
        // Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        // When
        final BigDecimal cost = order.getCost();
        // Then
        assertEquals(new BigDecimal(37), cost);
    }

    @Test
    public void testMyTaxiWithChildSeatGetDescription() {
        // Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new MyTaxiNetworkOrderDecorator(order);
        order = new ChildSeatDecorator(order);
        // When
        final String description = order.getDescription();
        // Then
        assertEquals("Drive a course by MyTaxi Network + child seat", description);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetCost() {
        // Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new VipDecorator(order);
        order = new ChildSeatDecorator(order);
        // When
        final BigDecimal cost = order.getCost();
        // Then
        assertEquals(new BigDecimal(52), cost);
    }

    @Test
    public void testVipTaxiWithChildSeatExpressGetDescription() {
        // Given
        TaxiOrder order = new BasicTaxiOrder();
        order = new TaxiNetworkOrderDecorator(order);
        order = new VipDecorator(order);
        order = new ChildSeatDecorator(order);
        // When
        final String description = order.getDescription();
        // Then
        assertEquals("Drive a course by Taxi Network + variant VIP + child seat", description);
    }
}
