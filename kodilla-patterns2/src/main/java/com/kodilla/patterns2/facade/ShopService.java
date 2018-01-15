package com.kodilla.patterns2.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class ShopService {
    private final List<Order> orders = new ArrayList<>();
    @Autowired
    private Authenticator authenticator;
    @Autowired
    private ProductService productService;

    public Long openOrder(final Long userId) {
        if (authenticator.isAuthenticated(userId)) {
            final Long maxOrder = (long) orders.stream()
                    .mapToInt(order -> order.getOrderId().intValue())
                    .max().orElse(0);
            orders.add(new Order(maxOrder + 1, userId, productService));
            return maxOrder + 1;
        }
        return -1L;
    }

    public void addItem(final Long orderId, final Long productId, final double qty) {
        orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .forEach(order -> order.getItems().add(new Item(productId, qty)));
    }

    public boolean removeItem(final Long orderId, final Long productId) {
        final Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            final Order order = orderIterator.next();
            final int orderSize = order.getItems().size();
            for (int n = 0; n < order.getItems().size(); n++) {
                if (order.getItems().get(n).getProductId().equals(productId)) {
                    order.getItems().remove(n);
                    return true;
                }
            }
        }
        return false;
    }

    public BigDecimal calculateValue(final Long orderId) {
        final Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getItems().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            final Order order = orderIterator.next();
            return order.calculateValue();
        }
        return BigDecimal.ZERO;
    }

    public boolean doPayment(final Long orderId) {
        final Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            final Order order = orderIterator.next();
            if (order.isPaid()) {
                return true;
            }
            final Random generator = new Random();
            order.setPaid(generator.nextBoolean());
            return order.isPaid();
        }
        return false;
    }

    public boolean verifyOrder(final Long orderId) {
        final Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            final Order order = orderIterator.next();
            final boolean result = order.isPaid();
            final Random generator = new Random();
            if (!order.isVerified()) {
                order.setVerified(result && generator.nextBoolean());
            }
            return order.isVerified();
        }
        return false;
    }

    public boolean submitOrder(final Long orderId) {
        final Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            final Order order = orderIterator.next();
            if (order.isVerified()) {
                order.setSubmitted(true);
            }
            return order.isSubmitted();
        }
        return false;
    }

    public void cancelOrder(final Long orderId) {
        final Iterator<Order> orderIterator = orders.stream()
                .filter(order -> order.getOrderId().equals(orderId))
                .iterator();
        while (orderIterator.hasNext()) {
            final Order order = orderIterator.next();
            orders.remove(order);
        }
    }
}