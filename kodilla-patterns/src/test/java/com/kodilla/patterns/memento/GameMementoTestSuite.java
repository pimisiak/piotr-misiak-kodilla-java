package com.kodilla.patterns.memento;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameMementoTestSuite {
    @Test
    public void testGameMemento() {
        //Given
        final Game game = new Game(0);
        final CareTaker<Game> careTaker = new GameCareTaker();
        careTaker.addMemento(game.storeInMemento());
        game.setHighscore(10);
        //When
        game.restorFromMemento(careTaker.getMemento());
        //Then
        assertEquals(0, game.getHighscore());
    }
}
