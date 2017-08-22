package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MovieStoreTestSuite {
    private MovieStore movieTitlesWithTranslations;

    @Before
    public void beforeTest() {
        movieTitlesWithTranslations = new MovieStore();
    }

    @Test
    public void testAddMovieShowTitles() {
        //Given
        movieTitlesWithTranslations.addMovie("IM", prepareIronManTranslations());
        movieTitlesWithTranslations.addMovie("AV", prepareAvengersTranslations());
        movieTitlesWithTranslations.addMovie("FL", prepareFlashTranslations());
        //Then
        final String result = movieTitlesWithTranslations.getStore().entrySet().stream()
                .flatMap(es -> es.getValue().stream())
                .collect(Collectors.joining("!"));
        //When
        Assert.assertEquals("Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash", result);
    }

    private List<String> prepareIronManTranslations() {
        final List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");
        return ironManTranslations;
    }

    private List<String> prepareAvengersTranslations() {
        final List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");
        return avengersTranslations;
    }

    private List<String> prepareFlashTranslations() {
        final List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");
        return flashTranslations;
    }
}
