package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.gorkapuente;

import javax.swing.*;
import java.awt.*;

public class NumberTable extends JTable {
    private static final int ROW_HEIGHT = 64;

    public NumberTable(NumberTableModel dm) {
        super(dm);

        // Renderer para la primera columna
        getColumnModel().getColumn(0).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JLabel lblCell = new JLabel(value.toString());
            lblCell.setFont(lblCell.getFont().deriveFont(Font.BOLD));
            lblCell.setHorizontalAlignment(JLabel.CENTER);
            return lblCell;
        });

        // Renderer para la segunda columna
        getColumnModel().getColumn(1).setCellRenderer(new NumberImageCellRenderer(dm.getMaxNumber()));
    }

    @Override
    public void setRowHeight(int rowHeight) {
        super.setRowHeight(ROW_HEIGHT);
    }
}
