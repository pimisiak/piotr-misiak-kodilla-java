package com.kodilla.spring.shape;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShapesFactory {
    @Bean
    public Square createSquare() {
        return new Square();
    }

    /**
     * Draws random shape.
     *
     * @return random shape
     */
    @Bean
    public Shape choosenShape() {
        final Shape shape;
        final Random generator = new Random();
        int choosen = generator.nextInt(3);
        if (choosen == 0) {
            shape = new Triangle();
        } else if (choosen == 1) {
            shape = new Circle();
        } else {
            shape = new Square();
        }
        return shape;
    }
}
