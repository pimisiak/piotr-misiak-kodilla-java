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
            if (validateIngredients(bigmac.ingredients) && validateSauce(bigmac.sauce) && validateBurgers(bigmac.burgers)) {
                return bigmac;
            }
            throw new IllegalStateException();
        }

        private boolean validateIngredients(final List<Ingredient> ingredients) {
            return ingredients.stream()
                    .allMatch(ingredient -> ingredient.equals(Ingredient.LETTUCE) || ingredient.equals(Ingredient.BACON)
                            || ingredient.equals(Ingredient.CHEESE) || ingredient.equals(Ingredient.CHILLIPEPPER)
                            || ingredient.equals(Ingredient.CUCUMBER) || ingredient.equals(Ingredient.MUSHROOM)
                            || ingredient.equals(Ingredient.ONION) || ingredient.equals(Ingredient.SHRIMP)
                    );
        }

        private boolean validateSauce(final Sauce sauce) {
            return sauce == Sauce.STANDARD || sauce == Sauce.BBQ || sauce == Sauce.ISLAND;
        }

        private boolean validateBurgers(final int burgers) {
            return burgers >= 0;
        }
    }
}
