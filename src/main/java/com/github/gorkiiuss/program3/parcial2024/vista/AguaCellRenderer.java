package com.github.gorkiiuss.program3.parcial2024.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AguaCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (isSelected) return lbl;

        float agua = (float) value;
        if (agua >= 10_000 && agua < 12_000)
            lbl.setBackground(Color.RED);
        else if (agua >= 12_000 && agua < 15_000)
            lbl.setBackground(Color.CYAN);
        else if (agua >= 15_000 && agua < 17_000)
            lbl.setBackground(Color.BLUE);
        else if (agua >= 17_000 && agua <= 20_000)
            lbl.setBackground(Color.GREEN);
        lbl.setText("");

        return lbl;
    }
}
