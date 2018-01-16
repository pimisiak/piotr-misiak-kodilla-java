package com.kodilla.patterns.memento;

public interface Originator<T> {
    MementoToCareTaker<T> storeInMemento();
    void restorFromMemento(final MementoToCareTaker<T> memento);
}
