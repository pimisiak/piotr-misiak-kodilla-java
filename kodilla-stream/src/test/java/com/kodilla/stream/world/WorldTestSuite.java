package com.kodilla.stream.world;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        final World world = buildTestWorld();
        //When
        final BigDecimal result = world.getPeopleQuantity();
        //Then
        final BigDecimal expectedResult = new BigDecimal("3327580793");
        Assert.assertEquals(expectedResult, result);
    }

    private World buildTestWorld() {
        final World world = new World();
        buildTestContinentEurope(world);
        buildTestContinentAsia(world);
        buildTestContinentAfrica(world);
        return world;
    }

    private void buildTestContinentEurope(final World world) {
        final Continent europe = new Continent("Europe");
        europe.addCountry(new Country("Poland", new BigDecimal("38494000")));
        europe.addCountry(new Country("Germany", new BigDecimal("82900000")));
        europe.addCountry(new Country("France", new BigDecimal("66991000")));
        world.addContinent(europe);
    }

    private void buildTestContinentAsia(final World world) {
        final Continent asia = new Continent("Asia");
        asia.addCountry(new Country("China", new BigDecimal("1387160793")));
        asia.addCountry(new Country("India", new BigDecimal("1299499000")));
        asia.addCountry(new Country("Japan", new BigDecimal("126891000")));
        world.addContinent(asia);
    }

    private void buildTestContinentAfrica(final World world) {
        final Continent africa = new Continent("Africa");
        africa.addCountry(new Country("Nigeria", new BigDecimal("181563000")));
        africa.addCountry(new Country("Egypt", new BigDecimal("89125000")));
        africa.addCountry(new Country("South Africa", new BigDecimal("54957000")));
        world.addContinent(africa);
    }
}
