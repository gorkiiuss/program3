package com.github.gorkiiuss.program3.io.basededatos.vista;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class TablaPeliculas extends JTable {
    public void setAspecto() {
        setRowHeight(30);
        for (int i = 0; i < getColumnCount(); i++) {
            getColumnModel().getColumn(i).setCellRenderer(new PeliculaCellRenderer());
        }
    }

    private static class PeliculaCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JLabel lblCell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            lblCell.setFont(new Font("Serif", Font.BOLD, 20));
            if (value instanceof Number)
                lblCell.setHorizontalAlignment(JLabel.CENTER);
            else lblCell.setHorizontalAlignment(JLabel.LEFT);

//            System.out.println(row);
//            System.out.println(table.getSelectedRow());
//            System.out.println(table.getSelectionBackground());
//            if (table.getSelectedRow() == row) lblCell.setBackground(table.getSelectionBackground());

            return lblCell;
        }
    }
}
