package com.github.gorkiiuss.program3.ejercicios.parcial2023.gorkapuente;

import javax.swing.*;
import java.awt.Component;
import java.net.URL;

public class EditorialCellRenderer extends AlternatingRowRenderer {

    private Icon dcIcon;
    private Icon marvelIcon;

    public EditorialCellRenderer() {
        // Cargar las imágenes desde los recursos
        URL dcIconUrl = getClass().getResource("/ejercicios/parcial2023/DC.png");
        URL marvelIconUrl = getClass().getResource("/ejercicios/parcial2023/MARVEL.png");

        if (dcIconUrl != null) {
            dcIcon = new ImageIcon(dcIconUrl);
        } else {
            // Manejar caso de imagen no encontrada
            System.err.println("No se encontró la imagen DC.png");
            dcIcon = null;
        }

        if (marvelIconUrl != null) {
            marvelIcon = new ImageIcon(marvelIconUrl);
        } else {
            // Manejar caso de imagen no encontrada
            System.err.println("No se encontró la imagen MARVEL.png");
            marvelIcon = null;
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // Obtener el componente predeterminado
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Basado en el valor, asignar el ícono correspondiente
        if (value instanceof Personaje.Editorial) {
            Personaje.Editorial editorial = (Personaje.Editorial) value;

            if (editorial == Personaje.Editorial.DC) {
                label.setIcon(dcIcon);
            } else if (editorial == Personaje.Editorial.MARVEL) {
                label.setIcon(marvelIcon);
            } else {
                label.setIcon(null);
            }
        }

        // Opcional: eliminar el texto de la celda
        label.setText(null);

        return label;
    }
}
