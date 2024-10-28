package com.github.gorkiiuss.program3.junit.ejemplo;

public class Counter {
    private int value;

    public Counter() {
        this.value = 0;
    }

    public void increment() {
        value++;
    }

    public void decrement() {
        if (value > 0) {
            value--;
        }
    }

    public int getValue() {
        return value;
    }

    public void invalidOperation() {
        throw new UnsupportedOperationException("This operation is not supported.");
    }

    public void reset() {
        value = -1;
    }
}