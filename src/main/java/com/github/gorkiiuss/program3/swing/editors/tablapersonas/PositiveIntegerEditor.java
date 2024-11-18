package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class PositiveIntegerEditor extends DefaultCellEditor {
    private JTextField tf;

    public PositiveIntegerEditor() {
        super(new JTextField());
        this.tf = (JTextField) getComponent();
    }

    @Override
    public Object getCellEditorValue() {
        int positiveNumber = 0;
        try {
            positiveNumber = Integer.parseInt(tf.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(tf, "Eso no es un numero!", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        if (positiveNumber < 0) {
            JOptionPane.showMessageDialog(tf, "El numero tiene que ser positivo!", "Error", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
        return positiveNumber;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return tf;
    }
}
