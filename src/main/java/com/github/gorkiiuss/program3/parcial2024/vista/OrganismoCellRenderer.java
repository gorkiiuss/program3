package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.parcial2024.modelo.Carnivoro;
import com.github.gorkiiuss.program3.parcial2024.modelo.Herviboro;
import com.github.gorkiiuss.program3.parcial2024.modelo.Organismo;
import com.github.gorkiiuss.program3.parcial2024.modelo.Planta;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class OrganismoCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lblCell = new JLabel(value.toString());
        lblCell.setOpaque(true); // Ensure the background is painted

        OrganismosTableModel modelo = (OrganismosTableModel) table.getModel();
        Class<? extends Organismo> tipoDeOrganismo = modelo.getData().getTipoDeOrganismo(row);

        if (isSelected) {
            lblCell.setBackground(table.getSelectionBackground());
            lblCell.setForeground(table.getSelectionForeground());
        } else {
            lblCell.setForeground(Color.DARK_GRAY);

            if (tipoDeOrganismo.equals(Planta.class)) {
                lblCell.setBackground(new Color(64, 255, 128));
            } else if (tipoDeOrganismo.equals(Herviboro.class)) {
                lblCell.setBackground(new Color(255, 255, 128));
            } else if (tipoDeOrganismo.equals(Carnivoro.class)) {
                lblCell.setBackground(new Color(255, 64, 64));
            } else {
                lblCell.setBackground(Color.WHITE);
            }
        }

        return lblCell;
    }
}
