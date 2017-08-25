package com.kodilla.good.patterns.challenges.order;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class Product {
    private final String type;
    private final double price;
    private final Map<String, String> properties = new HashMap<>();

    Product(final String type, final double price) {
        this.type = type;
        this.price = price;
    }

    String getType() {
        return type;
    }

    double getPrice() {
        return price;
    }

    Map<String, String> getProperties() {
        return Collections.unmodifiableMap(properties);
    }

    void addProperty(final String name, final String value) {
        properties.put(name, value);
    }

    @Override
    public String toString() {
        return "Product{" + "type='" + type + '\'' + ", price=" + price + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Product product = (Product) o;
        return Double.compare(product.price, price) == 0 && type.equals(product.type) && properties.equals(product.properties);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + properties.hashCode();
        return result;
    }
}
