package com.github.gorkiiuss.program3.ejercicios.parcial2023.gorkapuente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class AlternatingRowRenderer extends DefaultTableCellRenderer {
    private Color evenColor = new Color(250, 249, 249); // Color para filas pares
    private Color oddColor = new Color(190, 227, 219);  // Color para filas impares

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (!isSelected) {
            // Aplicamos el color de fondo según si la fila es par o impar
            if (row % 2 == 0) {
                c.setBackground(evenColor);
            } else {
                c.setBackground(oddColor);
            }
        } else {
            // Si la fila está seleccionada, usamos el color de selección predeterminado
            c.setBackground(table.getSelectionBackground());
        }

        return c;
    }
}
