package com.kodilla.patterns.memento;

public class GameMemento implements MementoToOriginator<Game>, MementoToCareTaker<Game> {
    private final Game game;

    public GameMemento(final Game game) {
        this.game = game;
    }

    @Override
    public Game getSavedState() {
        return game;
    }
}
