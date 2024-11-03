package com.github.gorkiiuss.program3.ejercicios.parcial2023.gorkapuente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class HeaderRenderer extends DefaultTableCellRenderer {
    public HeaderRenderer(int horizontalAlignment) {
        setHorizontalAlignment(horizontalAlignment);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        JLabel headerLabel = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Establecemos la alineación horizontal
        headerLabel.setHorizontalAlignment(getHorizontalAlignment());

        return headerLabel;
    }
}
