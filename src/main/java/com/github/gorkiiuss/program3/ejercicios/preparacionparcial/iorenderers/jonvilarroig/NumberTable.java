package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.jonvilarroig;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class NumberTable extends JTable {
    public NumberTable(TableModel dm) {
        super(dm);
        setRowHeight(64);

        // Renderer para la primera columna
        getColumnModel().getColumn(0).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JLabel lblCell = new JLabel(value.toString());
            lblCell.setFont(lblCell.getFont().deriveFont(Font.BOLD));
            lblCell.setHorizontalAlignment(JLabel.CENTER);
            return lblCell;
        });

        // Renderer para la segunda columna
        getColumnModel().getColumn(1).setCellRenderer(new NumberImageCellRenderer());
    }
}
