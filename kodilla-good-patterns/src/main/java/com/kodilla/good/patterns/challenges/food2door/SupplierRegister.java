package com.kodilla.good.patterns.challenges.food2door;

interface SupplierRegister {
    Supplier getSupplier(final int id) throws MissingSupplierException;
    void addSupplier(final int id, final Supplier supplier);
}
