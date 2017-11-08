package com.kodilla.patterns2.facade;

import java.math.BigDecimal;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    public BigDecimal getPrice(final Long productId) {
        final Random generator = new Random();
        return new BigDecimal(generator.nextInt(100000) / 100);
    }
}
