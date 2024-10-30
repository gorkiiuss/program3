package com.github.gorkiiuss.program3.junit.calculadora.calculator;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class DisplayView extends JTextField {
    private DisplayViewModel viewModel;

    public DisplayView() {

        setEditable(false);
        setHorizontalAlignment(JTextField.RIGHT);
        setBackground(new Color(0, 255, 0));
        setForeground(new Color(0, 64, 0));
        setFont(getCalculatorFontOrDefault());
    }

    private static Font getCalculatorFontOrDefault() {
        Font calculatorFont;
        try {
            calculatorFont = Font.createFont(
                    Font.TRUETYPE_FONT,
                    Objects.requireNonNull(
                            DisplayView.class.getResourceAsStream("/junit/calculadora/digital-7.ttf")
                    )
            ).deriveFont(80f);
        } catch (FontFormatException | IOException | NullPointerException e) {
            calculatorFont = new Font("Courier New", Font.PLAIN, 30);
        }

        return calculatorFont;
    }

    public void append(char c) {
        viewModel.append(c);
    }

    public void erase() {
        viewModel.erase();
    }

    public void appendAll(String s) {
        viewModel.showEvaluation(s);
    }

    public void clear() {
        viewModel.clear();
    }

    public void setViewModel(DisplayViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
