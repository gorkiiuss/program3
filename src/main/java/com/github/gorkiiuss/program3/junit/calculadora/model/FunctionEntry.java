package com.github.gorkiiuss.program3.junit.calculadora.model;

import java.util.Arrays;

public enum FunctionEntry {
    CLEAR('c'),
    ERASE('<'),
    EQUALS('='),
    HISTORY('H'),
    LEFT_PARENTHESIS('('),
    RIGHT_PARENTHESIS(')'),
    ;

    private final char id;

    FunctionEntry(char id) {
        this.id = id;
    }

    public static char[] getIDs() {
        FunctionEntry[] values = values();
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
