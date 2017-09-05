package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

final class SupplierRegisterImpl implements SupplierRegister {
    private final Map<Integer, Supplier> supplierRegister = new HashMap<>();

    @Override
    public void addSupplier(final int id, final Supplier supplier) {
        supplierRegister.put(id, supplier);
    }

    @Override
    public Supplier getSupplier(final int id) {
        return supplierRegister.get(id);
    }
}
