package com.kodilla.patterns2.decorator.pizza;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {
    @Test
    public void testPizzaOrderPepperoniWithPanGetCost() {
        // Given
        final PizzaOrder pizzaOrder = new PepperoniPizzaOrderDecorator(new PanPizzaOrderDecorator( new BasicPizzaOrder()));
        // When
        final BigDecimal price = pizzaOrder.getPrice();
        // Then
        assertEquals(new BigDecimal(22), price);
    }

    @Test
    public void testPizzaOrderPepperoniWithPanGetDescription() {
        // Given
        final PizzaOrder pizzaOrder = new PepperoniPizzaOrderDecorator(new PanPizzaOrderDecorator( new BasicPizzaOrder()));
        // When
        final String description = pizzaOrder.getDescription();
        // Then
        assertEquals("Pizza + tomato sauce + pan bread + pepperoni", description);
    }

    @Test
    public void testPizzaOrderMargharitaGetCost() {
        // Given
        final PizzaOrder pizzaOrder = new MargharitaPizzaOrderDecorator(new BasicPizzaOrder());
        // When
        final BigDecimal price = pizzaOrder.getPrice();
        // Then
        assertEquals(new BigDecimal(17), price);
    }

    @Test
    public void testPizzaOrderMargharitaGetDescription() {
        // Given
        final PizzaOrder pizzaOrder = new MargharitaPizzaOrderDecorator(new BasicPizzaOrder());
        // When
        final String description = pizzaOrder.getDescription();
        // Then
        assertEquals("Pizza + tomato sauce + cheese", description);
    }
}
