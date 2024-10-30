package com.github.gorkiiuss.program3.junit.calculadora.calculator;

import com.github.gorkiiuss.program3.junit.calculadora.model.Digit;
import com.github.gorkiiuss.program3.junit.calculadora.model.FunctionEntry;
import com.github.gorkiiuss.program3.junit.calculadora.model.Operation;

import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {
    private ButtonPanelViewModel viewModel;

    private final JPanel pnlDigits;
    private final JPanel pnlOperations;
    private final JPanel pnlFunctionEntries;

    public ButtonPanel() {
        super(new BorderLayout());

        this.pnlDigits = getPnlDigits();
        this.pnlOperations = getPnlOperations();
        this.pnlFunctionEntries = getPnlFunctionEntries();

        add(pnlDigits, BorderLayout.CENTER);
        add(pnlOperations, BorderLayout.EAST);
        add(pnlFunctionEntries, BorderLayout.NORTH);
    }

    private JPanel getPnlFunctionEntries() {
        if (pnlFunctionEntries != null)
            return pnlFunctionEntries;

        char[] functionEntries = FunctionEntry.getIDs();

        int columns = 3;
        int rows = (functionEntries.length + columns - 1) / columns;
        JPanel pnlFunctionEntries = new JPanel(new GridLayout(rows, columns));

        JButton btnFunctionEntry;

        for (char functionEntry : functionEntries) {
            btnFunctionEntry = new JButton(String.valueOf(functionEntry));
            btnFunctionEntry.addActionListener(e -> viewModel.setSelectedEntry(functionEntry));
            pnlFunctionEntries.add(btnFunctionEntry);
        }

        for (int i = 0; i < rows * columns - functionEntries.length; i++) {
            pnlFunctionEntries.add(new JLabel());
        }

        return pnlFunctionEntries;
    }

    private JPanel getPnlOperations() {
        if (pnlOperations != null)
            return pnlOperations;

        char[] operations = Operation.getAllSupportedOperationsID();
        int rows = 4;
        int columns = (operations.length + rows - 1) / rows; // Ceil integer division
        JPanel pnlOperations = new JPanel(new GridLayout(rows, columns));

        JButton btnOperation;
        for (int j = 0; j < rows; j++) {
            for (int i = 0; i < columns; i++) {
                int index = i * rows + j;
                if (index >= operations.length) {
                    pnlOperations.add(new JLabel());
                } else {
                    char operation = operations[index];
                    btnOperation = new JButton(String.valueOf(operation));
                    btnOperation.addActionListener(e -> viewModel.setSelectedEntry(operation));
                    pnlOperations.add(btnOperation);
                }
            }
        }

        return pnlOperations;
    }

    private JPanel getPnlDigits() {
        if (pnlDigits != null)
            return pnlDigits;

        char[] digits = Digit.getIDs();

        JPanel pnlDigits = new JPanel(new GridLayout(4, 3, 5, 5));

        JButton btnDigit;
        int index = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 3 && j == 0)
                    btnDigit = new JButton(" ");
                else {
                    char digit = digits[index];
                    btnDigit = new JButton(String.valueOf(digit));
                    btnDigit.addActionListener(e -> viewModel.setSelectedEntry(digit));
                    index++;
                }
                pnlDigits.add(btnDigit);
            }
        }

        return pnlDigits;
    }

    public void setViewModel(ButtonPanelViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
