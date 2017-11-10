package com.kodilla.patterns2.observer.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumTopic implements Observable {
    private final List<Observer> observers;
    private final List<String> messages;
    private final String name;

    public ForumTopic(final String name) {
        observers = new ArrayList<>();
        messages = new ArrayList<>();
        this.name = name;
    }

    public void addPost(final String post) {
        messages.add(post);
        notifyObservers();
    }

    @Override
    public void registerObserver(final Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (final Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(final Observer observer) {
        observers.remove(observer);
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }
}
