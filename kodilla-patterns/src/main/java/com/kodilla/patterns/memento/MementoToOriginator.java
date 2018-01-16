package com.kodilla.patterns.memento;

public interface MementoToOriginator<T> {
    T getSavedState();
}
