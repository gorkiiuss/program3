package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.time.LocalDate;

public class LocalDateEditor extends DefaultCellEditor {
    private final JTextField tf;
    public LocalDateEditor() {
        super(new JTextField());
        tf = (JTextField) getComponent();
    }

    @Override
    public Object getCellEditorValue() {
        String[] valores = tf.getText().split("-"); // 2020-10-05
        return LocalDate.of(Integer.parseInt(valores[0]), Integer.parseInt(valores[1]), Integer.parseInt(valores[2]));
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return tf;
    }
}
