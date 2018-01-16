package com.kodilla.patterns.memento;

public interface CareTaker<T> {
    void addMemento(final MementoToCareTaker<T> memento);
    MementoToCareTaker<T> getMemento();
}
