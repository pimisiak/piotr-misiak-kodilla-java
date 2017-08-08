package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class WeatherForecast {
    private Temperatures temperatures;

    public WeatherForecast(final Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    /**
     * Method calculates weather forecast.
     *
     * @return Returns HashMap with calculated weather forecast
     */
    public HashMap<Integer, Double> calculateForecast() {
        final HashMap<Integer, Double> resultMap = new HashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }
}
