package com.kodilla.patterns.memento;

public class Game implements Originator<Game> {
    private int highscore;

    public Game(final int highscore) {
        this.highscore = highscore;
    }

    public Game(final Game game) {
        highscore = game.getHighscore();
    }

    public int getHighscore() {
        return highscore;
    }

    public void setHighscore(final int highscore) {
        this.highscore = highscore;
    }

    @Override
    public MementoToCareTaker<Game> storeInMemento() {
        return new GameMemento(new Game(this));
    }

    @Override
    public void restorFromMemento(final MementoToCareTaker<Game> memento) {
        highscore = ((MementoToOriginator<Game>) memento).getSavedState().getHighscore();
    }
}
