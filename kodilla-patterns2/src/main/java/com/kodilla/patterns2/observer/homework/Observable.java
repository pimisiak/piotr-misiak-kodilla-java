package com.kodilla.patterns2.observer.homework;

public interface Observable {
    boolean registerObserver(final Observer observer);
    void notifyObservers();
    void removeObserver(final Observer observer);
}
