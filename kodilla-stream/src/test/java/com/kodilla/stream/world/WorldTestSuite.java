package com.kodilla.stream.world;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        final World world = new World();
        final Continent europe = new Continent("Europe");
        final Continent asia = new Continent("Asia");
        final Continent africa = new Continent("Africa");
        europe.addCountry(new Country("Poland", new BigDecimal("38494000")));
        europe.addCountry(new Country("Germany", new BigDecimal("82900000")));
        europe.addCountry(new Country("France", new BigDecimal("66991000")));
        asia.addCountry(new Country("China", new BigDecimal("1387160793")));
        asia.addCountry(new Country("India", new BigDecimal("1299499000")));
        asia.addCountry(new Country("Japan", new BigDecimal("126891000")));
        africa.addCountry(new Country("Nigeria", new BigDecimal("181563000")));
        africa.addCountry(new Country("Egypt", new BigDecimal("89125000")));
        africa.addCountry(new Country("South Africa", new BigDecimal("54957000")));
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        //When
        final BigDecimal result = world.getPeopleQuantity();
        //Then
        final BigDecimal expectedResult = new BigDecimal("3327580793");
        Assert.assertEquals(expectedResult, result);
    }
}
