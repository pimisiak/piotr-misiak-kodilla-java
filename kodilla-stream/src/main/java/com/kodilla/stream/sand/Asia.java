package com.kodilla.stream.sand;

import java.math.BigDecimal;

final class Asia implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("98765432101234567890");
    }
}