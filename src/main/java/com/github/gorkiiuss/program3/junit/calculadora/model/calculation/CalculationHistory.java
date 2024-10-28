package com.github.gorkiiuss.program3.junit.calculadora.model.calculation;

import java.util.ArrayList;
import java.util.List;

public class CalculationHistory {
    private static CalculationHistory instance;

    private final List<Calculation> calculations = new ArrayList<Calculation>();

    private CalculationHistory() {

    }

    public static synchronized CalculationHistory get() {
        if (instance == null)
            instance = new CalculationHistory();
        return instance;
    }

    public void addCalculation(Calculation calculation) {
        calculations.add(calculation);
    }

    public void showHistory() {
        System.out.println("Calculation history");
        calculations.forEach(System.out::println);
    }
}
