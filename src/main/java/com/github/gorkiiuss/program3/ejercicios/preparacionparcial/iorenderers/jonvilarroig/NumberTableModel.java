package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.jonvilarroig;

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
        // TODO: El valor que se guarda en la tabla debe ser siempre el numero de la fila
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
        // TODO: ¿Qué hay que hacer cada vez que se actualiza una fila?
        fireTableRowsUpdated(0, getRowCount());
    }

    public boolean isShowing() {
        return showing;
    }
}
