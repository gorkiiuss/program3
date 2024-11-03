package com.github.gorkiiuss.program3.ejercicios.parcial2023.gorkapuente;

import javax.swing.*;
import java.awt.*;

public class AlignedCellRenderer extends AlternatingRowRenderer {
    private int horizontalAlignment;

    public AlignedCellRenderer(int horizontalAlignment) {
        this.horizontalAlignment = horizontalAlignment;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Llamamos al método de la superclase para aplicar colores de fondo
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Establecemos la alineación horizontal
        label.setHorizontalAlignment(horizontalAlignment);

        return label;
    }
}
