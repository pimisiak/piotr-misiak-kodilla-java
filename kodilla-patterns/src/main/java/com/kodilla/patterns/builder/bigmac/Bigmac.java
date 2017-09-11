package com.kodilla.patterns.builder.bigmac;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Bigmac {
    private final boolean rollWithSesame;
    private final int burgers;
    private final Sauce sauce;
    private final List<Ingredient> ingredients;

    Bigmac(final Builder builder) {
        rollWithSesame = builder.rollWithSesame;
        burgers = builder.burgers;
        sauce = builder.sauce;
        ingredients = builder.ingredients;
    }

    boolean isRollWithSesame() {
        return rollWithSesame;
    }

    int getBurgers() {
        return burgers;
    }

    Sauce getSauce() {
        return sauce;
    }

    List<Ingredient> getIngredients() {
        return Collections.unmodifiableList(ingredients);
    }

    static class Builder {
        private boolean rollWithSesame = false;
        private int burgers = 1;
        private Sauce sauce;
        private List<Ingredient> ingredients = new ArrayList<>();

        Builder rollWithSesame(final boolean rollWithSesame) {
            this.rollWithSesame = rollWithSesame;
            return this;
        }

        Builder burgers(final int burgers) {
            this.burgers = burgers;
            return this;
        }

        Builder sauce(final Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        Builder ingredient(final Ingredient ingredient) {
            ingredients.add(ingredient);
            return this;
        }

        Bigmac build() {
            final Bigmac bigmac = new Bigmac(this);
            if (validateBurgers(bigmac.burgers)) {
                return bigmac;
            }
            throw new IllegalStateException();
        }

        private boolean validateBurgers(final int burgers) {
            return burgers >= 0;
        }
    }
}
