package com.kodilla.stream.sand;

import java.math.BigDecimal;

final class Europe implements SandStorage {
    @Override
    public BigDecimal getSandBeansQuantity() {
        return new BigDecimal("12345678901234567890");
    }
}
