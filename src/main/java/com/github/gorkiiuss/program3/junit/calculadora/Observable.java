package com.github.gorkiiuss.program3.junit.calculadora;

import java.util.ArrayList;

public abstract class Observable {
    private final ArrayList<Observer> observers;

    public Observable() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers(Object... args) {
        observers.forEach(observer -> observer.update(this, args));
    }
}
