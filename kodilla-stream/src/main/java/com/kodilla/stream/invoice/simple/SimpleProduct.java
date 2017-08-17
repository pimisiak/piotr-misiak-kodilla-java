package com.kodilla.stream.invoice.simple;

final class SimpleProduct {
    private final String productName;
    private final double productPrice;

    SimpleProduct(final String productName, final double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    String getProductName() {
        return productName;
    }

    double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SimpleProduct that = (SimpleProduct) o;
        return productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }
}
