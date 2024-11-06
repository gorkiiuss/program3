package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.esqueleto.mafer;

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
    	
    	if (isSelected==true) {
    		
    	
        URL url= NumberImageCellRenderer.class.getResource("/ejercicios/preparacionparcial/iorenderers"+"/image_" +value+".png");
		
		ImageIcon imagen= new ImageIcon(url);
		JLabel label= new JLabel();
		label.setIcon(imagen);
		
		
	
		return label;
		
    }else {
    	
    	boolean showing = ((NumberTableModel) table.getModel()).isShowing();
    	JLabel label= new JLabel("No se muestran imagenes");
    	return label;
    	
    }
}
}
