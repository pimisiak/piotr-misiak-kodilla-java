package com.kodilla.patterns.builder.bigmac;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilder() {
        //Given
        final Bigmac bigmac = new Bigmac.Builder()
                .burgers(2)
                .ingredient(Ingredient.BACON)
                .ingredient(Ingredient.CHEESE)
                .ingredient(Ingredient.CHILLIPEPPER)
                .rollWithSesame(true)
                .sauce(Sauce.STANDARD)
                .build();
        //When
        final int burgers = bigmac.getBurgers();
        final List<Ingredient> ingredients = bigmac.getIngredients();
        final Sauce sauce = bigmac.getSauce();
        final boolean rollWithSesame =  bigmac.isRollWithSesame();
        //Then
        Assert.assertEquals(2, burgers);
        Assert.assertEquals(Sauce.STANDARD, sauce);
        Assert.assertEquals(3, ingredients.size());
        Assert.assertThat(ingredients, CoreMatchers.hasItems(Ingredient.BACON, Ingredient.CHEESE, Ingredient.CHILLIPEPPER));
        Assert.assertTrue(rollWithSesame);
    }
}
