package com.kodilla.testing.weather.stub;

import org.junit.Test;
import org.junit.Assert;

public class WeatherForecastTestSuite {
    @Test
    public void testCalculateForecastWithStub() {
        //Given
        final Temperatures temperatures = new TemperaturesStub();
        final WeatherForecast weatherForecast = new WeatherForecast(temperatures);
        //When
        final int quantityOfSensors = weatherForecast.calculateForecast().size();
        //Then
        Assert.assertEquals(5, quantityOfSensors);
    }
}
