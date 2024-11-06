package es.deusto.prog3.cap03.ejercicios.superheroes;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class EditorialCellRender extends DefaultTableCellRenderer {

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
			JLabel lblCell = (JLabel) super.getTableCellRendererComponent(table,value, isSelected, hasFocus, row, column);
			lblCell.setText(null);
			Personaje.Editorial editorial = (Personaje.Editorial) value;
			if 
			lblCell.setIcon(new ImageIcon(EditorialCellRender.class.getResource("/ejercicios/parcial2023/DC.png")));
			
		return lblCell;
	}

}
