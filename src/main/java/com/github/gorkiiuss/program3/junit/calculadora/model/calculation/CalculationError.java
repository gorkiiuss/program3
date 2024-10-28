package com.github.gorkiiuss.program3.junit.calculadora.model.calculation;

public enum CalculationError {
    NONE(""),
    SYNTAX("Stx Error!"),
    MATH("Math Error!"),
    ;

    private final String msg;

    CalculationError(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}