package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.gorkapuente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class NumberTableModel extends DefaultTableModel {
    private final int maxNumber;
    private boolean showing;

    public NumberTableModel(int maxNumber) {
        this.maxNumber = maxNumber;
        addColumn("Numbers");
        addColumn("Number images");
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return row;
    }

    public void addRow() {
        if (getRowCount() - 1 == maxNumber) JOptionPane.showMessageDialog(
                null,
                "No se puede superar el valor máximo introducido!",
                "Error", JOptionPane.ERROR_MESSAGE
        );
        else super.addRow(new Object[]{});
    }

    public void setShowing(boolean showing) {
        this.showing = showing;
        fireTableRowsUpdated(0, getRowCount() - 1);
    }

    public boolean isShowing() {
        return showing;
    }

    public int getMaxNumber() {
        return this.maxNumber;
    }
}
