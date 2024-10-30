package com.github.gorkiiuss.program3.junit.calculadora.calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorView extends JPanel {
    private DisplayView display;
    private ButtonPanel pnlButtons;

    public CalculatorView() {
        this.pnlButtons = new ButtonPanel();
        this.display = new DisplayView();

        ButtonPanelViewModel butonPanelViewModel = new ButtonPanelViewModel();
        DisplayViewModel displayViewModel = new DisplayViewModel(display);
        butonPanelViewModel.addObserver(displayViewModel);
        this.pnlButtons.setViewModel(butonPanelViewModel);
        this.display.setViewModel(displayViewModel);

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(pnlButtons, BorderLayout.CENTER);
    }
}
