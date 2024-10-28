package com.github.gorkiiuss.program3.junit.calculadora.model;

public enum Digit {
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    ONE('1'),
    TWO('2'),
    THREE('3'),
    ZERO('0'),
    DOT('.');
    ;

    private final char id;

    Digit(char id) {
        this.id = id;
    }

    public static char[] getIDs() {
        Digit[] values = values();
        char[] ids = new char[values.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = values[i].getID();
        }
        return ids;
    }

    public char getID() {
        return id;
    }
}
