package com.github.gorkiiuss.program3.junit.calculadora.model.calculation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    @Test
    void parseExpressionTest() {
        assertEquals(CalculationError.SYNTAX, Calculation.parseExpression("9..2+2").getCalculationError());
        assertEquals(CalculationError.SYNTAX, Calculation.parseExpression("9.2+*2").getCalculationError());
        assertEquals(CalculationError.MATH, Calculation.parseExpression("9.2+2/0.0").getCalculationError());
        assertEquals(CalculationError.NONE, Calculation.parseExpression("9.2+2").getCalculationError());
    }
}