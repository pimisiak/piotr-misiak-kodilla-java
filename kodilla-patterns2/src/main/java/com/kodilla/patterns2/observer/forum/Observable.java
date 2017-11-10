package com.kodilla.patterns2.observer.forum;

public interface Observable {
    void registerObserver(final Observer observer);
    void notifyObservers();
    void removeObserver(final Observer observer);
}
