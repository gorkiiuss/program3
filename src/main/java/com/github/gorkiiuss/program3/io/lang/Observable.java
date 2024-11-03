package com.github.gorkiiuss.program3.io.lang;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    protected void notifyObservers(Object... args) {
        this.observers.forEach(observer -> observer.update(this, args));
    }
}
