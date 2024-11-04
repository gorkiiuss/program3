package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.esqueleto;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class NumberImageCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        /*
         TODO: La celda debe renderizar una etiqueta con dos variantes posibles. Si el boton `Mostrar imagenes` no esta
          seleccionado debe mostrar el texto "Suplente de la imagen nª `value`". Si el boton esta seleccionado, entonces
          debe mostrar la imagen correspondiente. En este caso las imagenes estan guardadas en
          "/ejercicios/preparacionparcial/iorenderers/" bajo el nombre "image_`value`.png".
        */
        return null;
    }
}
