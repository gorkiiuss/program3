package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import javax.swing.*;
import java.awt.*;

public class BooleanCellEditor extends DefaultCellEditor {

    private JCheckBox checkBox;

    public BooleanCellEditor() {
        super(new JCheckBox());
        checkBox = (JCheckBox) getComponent();
        checkBox.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public Object getCellEditorValue() {
        return checkBox.isSelected();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        // Establecer el estado del JCheckBox basado en el valor de la celda
        boolean b = (boolean) value;
        checkBox.setSelected(b);
        return checkBox;
    }
}
