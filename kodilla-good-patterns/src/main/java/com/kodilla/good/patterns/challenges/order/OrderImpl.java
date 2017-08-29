package com.kodilla.good.patterns.challenges.order;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class OrderImpl implements Order {
    private final int id;
    private final User user;
    private final LocalDateTime dateOfOrder;
    private final String shippingAddress;
    private final Map<Product, Integer> products = new HashMap<>();

    private OrderImpl(final OrderImplBuilder builder) {
        this.id = builder.orderId;
        this.user = builder.user;
        this.dateOfOrder = builder.dateOfOrder;
        this.shippingAddress = builder.shippingAddress;
    }

    public double orderPrice() {
        return products.entrySet().stream()
                .mapToDouble(es -> es.getKey().getPrice() * es.getValue())
                .sum();
    }

    public void addProduct(final Product product, final int quantity) {
        products.put(product, quantity);
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getInformation() {
        return toString();
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
    public String toString() {
        return "Order{" + "id=" + id + ", user=" + user + ", dateOfOrder=" + dateOfOrder + ", shippingAddress='" + shippingAddress + '\''
                + ", products=" + products + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final OrderImpl order = (OrderImpl) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    static class OrderImplBuilder {
        private final int orderId;
        private User user;
        private LocalDateTime dateOfOrder;
        private String shippingAddress;

        OrderImplBuilder(final int orderId) {
            this.orderId = orderId;
        }

        OrderImplBuilder user(final User user) {
            this.user = user;
            return this;
        }

        OrderImplBuilder dateOfOrder(final LocalDateTime dateOfOrder) {
            this.dateOfOrder = dateOfOrder;
            return this;
        }

        OrderImplBuilder shippingAddress(final String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        OrderImpl build() {
            return new OrderImpl(this);
        }
    }
}
