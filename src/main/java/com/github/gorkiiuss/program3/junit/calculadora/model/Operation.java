package com.github.gorkiiuss.program3.junit.calculadora.model;

import java.util.Arrays;

public enum Operation {
    SUMMATION('+', Double::sum),
    SUBTRACTION('-', (o1, o2) -> o1 - o2),
    MULTIPLICATION('*', (o1, o2) -> o1 * o2),
    DIVISION('/', (o1, o2) -> o1 / o2),
    POWER('^', Math::pow)

    ;

    private char id;
    private Evaluation evaluation;

    Operation(char id, Evaluation evaluation) {
        this.id = id;
        this.evaluation = evaluation;
    }

    public double evaluate(double operand1, double operand2) {
        return evaluation.evaluate(operand1, operand2);
    }

    public static Operation getOperation(char id) {
        return Arrays.stream(values()).filter(operation -> operation.hasID(id)).findFirst().orElse(null);
    }

    public static boolean isSupportedOperation(char id) {
        return Arrays.stream(values()).anyMatch(operation -> operation.hasID(id));
    }

    public static char[] getAllSupportedOperationsID() {
        char[] allSupportedOperationsID = new char[values().length];
        for (int i = 0; i < values().length; i++) {
            allSupportedOperationsID[i] = values()[i].getID();
        }
        return allSupportedOperationsID;
    }

    public boolean hasID(char id) {
        return this.id == id;
    }

    public char getID() {
        return this.id;
    }
}