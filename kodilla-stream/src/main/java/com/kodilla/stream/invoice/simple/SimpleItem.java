package com.kodilla.stream.invoice.simple;

final class SimpleItem {
    private final SimpleProduct product;
    private final double quantity;

    SimpleItem(final SimpleProduct product, final double quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    SimpleProduct getProduct() {
        return product;
    }

    double getQuantity() {
        return quantity;
    }

    double getValue() {
        return product.getProductPrice() * quantity;
    }
}
