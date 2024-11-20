package com.github.gorkiiuss.program3.parcial2024.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.net.URL;

public class ClimaCellRenderer extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        String direccion = "/parcial2024/" + value.toString().toLowerCase() + ".jpg";
        URL url = ClimaCellRenderer.class.getResource(direccion);
        JLabel lbl = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        lbl.setIcon(new ImageIcon(url));
        return lbl;
    }
}
