package com.kodilla.patterns.memento;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameCareTaker implements CareTaker<Game> {
    private final Deque<MementoToCareTaker<Game>> mementos = new ArrayDeque<>();

    @Override
    public void addMemento(final MementoToCareTaker<Game> memento) {
        mementos.addFirst(memento);
    }

    @Override
    public MementoToCareTaker<Game> getMemento() {
        return mementos.removeFirst();
    }
}
