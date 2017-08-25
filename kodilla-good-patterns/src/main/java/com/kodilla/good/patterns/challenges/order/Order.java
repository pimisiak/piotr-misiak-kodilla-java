package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Order {
    private final int orderId;
    private final User user;
    private final LocalDateTime dateOfOrder;
    private final String shippingAddress;
    private final Map<Product, Integer> products = new HashMap<>();

    private Order(final OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.user = builder.user;
        this.dateOfOrder = builder.dateOfOrder;
        this.shippingAddress = builder.shippingAddress;
    }

    double orderPrice() {
        return products.entrySet().stream()
                .mapToDouble(es -> es.getKey().getPrice() * es.getValue())
                .sum();
    }

    void addProduct(final Product product, final int quantity) {
        products.put(product, quantity);
    }

    int getOrderId() {
        return orderId;
    }

    User getUser() {
        return user;
    }

    LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    String getShippingAddress() {
        return shippingAddress;
    }

    Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Order order = (Order) o;
        return orderId == order.orderId;
    }

    @Override
    public int hashCode() {
        return orderId;
    }

    static class OrderBuilder {
        private final int orderId;
        private User user;
        private LocalDateTime dateOfOrder;
        private String shippingAddress;

        OrderBuilder(final int orderId) {
            this.orderId = orderId;
        }

        OrderBuilder user(final User user) {
            this.user = user;
            return this;
        }

        OrderBuilder dateOfOrder(final LocalDateTime dateOfOrder) {
            this.dateOfOrder = dateOfOrder;
            return this;
        }

        OrderBuilder shippingAddress(final String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        Order build() {
            return new Order(this);
        }
    }
}
