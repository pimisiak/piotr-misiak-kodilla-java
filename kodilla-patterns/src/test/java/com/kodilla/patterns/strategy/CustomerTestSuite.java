package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTestSuite {
    @Test
    public void testDefaultInvestingStrategies() {
        //Given
        final Customer steven = new IndividualCustomer("Steven Links");
        final Customer john = new IndividualYoungCustomer("John Hemerald");
        final Customer kodilla = new CorporateCustomer("Kodilla");

        //When
        final String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        final String johnShouldBuy = john.predict();
        System.out.println("John should: " + johnShouldBuy);
        final String kodillaShouldBuy = kodilla.predict();
        System.out.println("Kodilla should: " + kodillaShouldBuy);

        //Then
        Assert.assertEquals("[Conservative predictor] Buy debentures of XYZ", stevenShouldBuy);
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ", johnShouldBuy);
        Assert.assertEquals("[Balanced predictor] Buy shared units of Fund XYZ", kodillaShouldBuy);
    }

    @Test
    public void testIndividualInvestingStrategy() {
        //Given
        final Customer steven = new IndividualCustomer("Steven Links");

        //When
        String stevenShouldBuy = steven.predict();
        System.out.println("Steven should: " + stevenShouldBuy);
        steven.setBuyingStrategy(new AggressivePredictor());
        stevenShouldBuy = steven.predict();
        System.out.println("Steven now should: " + stevenShouldBuy);

        //Then
        Assert.assertEquals("[Aggressive predictor] Buy stock of XYZ", stevenShouldBuy);
    }
}