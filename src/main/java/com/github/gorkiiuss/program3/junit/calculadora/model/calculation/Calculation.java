package com.github.gorkiiuss.program3.junit.calculadora.model.calculation;

import com.github.gorkiiuss.program3.junit.calculadora.model.Operation;

import java.util.regex.Pattern;

public class Calculation {
    private final String expression;
    private final double[] operands;
    private final char[] operations;
    private final CalculationError calculationError;

    public static Calculation parseExpression(String expression) {
        // No se puede poner dos puntos seguidos:
        if (Pattern.compile("\\.\\.").matcher(expression).find())
            return new Calculation(expression, null, null, CalculationError.SYNTAX);

        // No se puede tener dos operadores seguidos
        if (Pattern.compile("[+\\-*/^][+\\-*/^]+").matcher(expression).find()) {
            return new Calculation(expression, null, null, CalculationError.SYNTAX);
        }

        // No se puede dividir entre cero:
        if (Pattern.compile("/0+(.0+)?").matcher(expression).find()) {
            return new Calculation(expression, null, null, CalculationError.MATH);
        }

        String[] operandsString = expression.split("[+\\-*/]");
        String[] operationsString = expression.split("[0-9.]");
        char[] trimmedOperationsString = new char[operandsString.length - 1];

        double[] operands = new double[operandsString.length];
        for (int i = 0; i < operandsString.length; i++) {
            operands[i] = Double.parseDouble(operandsString[i]);
        }

        int j = 0;
        for (String s : operationsString) {
            if (!s.isEmpty()) {
                trimmedOperationsString[j] = s.charAt(0);
                j++;
            }
        }

        return new Calculation(expression, operands, trimmedOperationsString);
    }

    public Calculation(String expression, double[] operands, char[] operations) {
        this.expression = expression;
        this.operands = operands;
        this.operations = operations;
        this.calculationError = CalculationError.NONE;
    }

    public Calculation(String expression, double[] operands, char[] operations, CalculationError calculationError) {
        this.expression = expression;
        this.operands = operands;
        this.operations = operations;
        this.calculationError = calculationError;
    }

    public double evaluate() {
        double evaluation = operands[0];
        for (int i = 0; i < operations.length; i++)
            evaluation = Operation.getOperation(operations[i]).evaluate(evaluation, operands[i + 1]);
        return evaluation;
    }

    @Override
    public String toString() {
        if (this.calculationError == CalculationError.SYNTAX || this.calculationError == CalculationError.MATH)
            return expression + ": " + calculationError.getMsg();

        return expression + " = " + this.evaluate();
    }

    public CalculationError getCalculationError() {
        return calculationError;
    }
}
