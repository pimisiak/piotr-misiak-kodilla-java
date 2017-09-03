package com.kodilla.good.patterns.challenges.food2door;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class OrderImpl implements Order {
    private final int id;
    private final User user;
    private final LocalDateTime dateOfOrder;
    private final String shippingAddress;
    private final Map<Food, Integer> products;

    private OrderImpl(final Builder builder) {
        this.id = builder.id;
        this.user = builder.user;
        this.dateOfOrder = builder.dateOfOrder;
        this.shippingAddress = builder.shippingAddress;
        this.products = builder.products;
    }

    @Override
    public double orderPrice() {
        return products.entrySet().stream()
                .mapToDouble(es -> es.getKey().getPrice() * es.getValue())
                .sum();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public User getUser() {
        return user;
    }

    LocalDateTime getDateOfOrder() {
        return dateOfOrder;
    }

    String getShippingAddress() {
        return shippingAddress;
    }

    @Override
    public Map<Food, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }

    @Override
    public String toString() {
        return String.format("Order{id=%d, user=%s, dateOfOrder=%s, shippingAddress='%s', products=%s}", id, user, dateOfOrder, shippingAddress, products);
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

    static class Builder {
        private final int id;
        private User user;
        private LocalDateTime dateOfOrder;
        private String shippingAddress;
        private final Map<Food, Integer> products = new HashMap<>();

        Builder(final int id) {
            this.id = id;
        }

        Builder user(final User user) {
            this.user = user;
            return this;
        }

        Builder dateOfOrder(final LocalDateTime dateOfOrder) {
            this.dateOfOrder = dateOfOrder;
            return this;
        }

        Builder shippingAddress(final String shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        Builder addProduct(final Food product, final int quantity) {
            products.put(product, quantity);
            return this;
        }

        OrderImpl build() {
            return new OrderImpl(this);
        }
    }
}
