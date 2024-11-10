package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.gorkapuente;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.net.URL;

public class NumberImageCellRenderer extends DefaultTableCellRenderer {
    private static final String IMAGES_PATH = "/ejercicios/preparacionparcial/iorenderers/";
    private final Icon[] numberImages;

    public NumberImageCellRenderer(int maxNumber) {
        this.numberImages = new Icon[maxNumber + 1];
        for (int i = 0; i < this.numberImages.length; i++) {
            String IMAGE_PATH = IMAGES_PATH + "image_" + i + ".png";
            URL urlImage = getClass().getResource(IMAGE_PATH);
            if (urlImage == null) {
                System.err.println("No se encontro la imagen " + IMAGE_PATH);
                numberImages[i] = null;
            } else {
                numberImages[i] = new ImageIcon(urlImage);
            }
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel lblCell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        Icon imageIcon = numberImages[Integer.parseInt(value.toString())];
        if (imageIcon != null && ((NumberTableModel) table.getModel()).isShowing()) {
            lblCell.setIcon(imageIcon);
            lblCell.setText(null);
        }
        else {
            lblCell.setIcon(null);
            lblCell.setText("Suplente de la imagen nº " + value);
        }

        lblCell.setFont(lblCell.getFont().deriveFont(Font.BOLD));
        lblCell.setHorizontalAlignment(JLabel.CENTER);

        return lblCell;
    }
}
