package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.jonvilarroig;


import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.net.URL;

public class NumberImageCellRenderer implements TableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        /*
         TODO: La celda debe renderizar una etiqueta con dos variantes posibles. Si el boton `Mostrar imagenes` no esta
          seleccionado debe mostrar el texto "Suplente de la imagen nª `value`". Si el boton esta seleccionado, entonces
          debe mostrar la imagen correspondiente. En este caso las imagenes estan guardadas en
          "/ejercicios/preparacionparcial/iorenderers/" bajo el nombre "image_`value`.png".
        */
    	JLabel label = new JLabel();
    	boolean enseña  = ((NumberTableModel)table.getModel()).isShowing();
	    	if (enseña == true) {
		    	URL url = NumberImageCellRenderer.class.getResource("/ejercicios/preparacionparcial/iorenderers/"+"image_"+row+".png");
		    	
		    	ImageIcon imagen = new ImageIcon(url);
		    	label.setIcon(imagen);
		    	label.setHorizontalAlignment(JLabel.CENTER);
	    	}else {
	    		label.setText("reemplazo de la foto por el valor"+row);
	    		label.setHorizontalAlignment(JLabel.CENTER);
	    	}
        return label;
        
    }
}
