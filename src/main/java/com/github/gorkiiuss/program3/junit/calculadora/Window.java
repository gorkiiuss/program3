package com.github.gorkiiuss.program3.junit.calculadora;

import com.github.gorkiiuss.program3.junit.calculadora.calculator.CalculatorView;

import javax.swing.*;

public class Window extends JFrame {
    private CalculatorView calculatorView;

    public Window() {
        super("Calculadora");
        setSize(400, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.calculatorView = new CalculatorView();

        add(calculatorView);
    }
}
