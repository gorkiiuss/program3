package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PersonaTableModel extends DefaultTableModel {

    private String[] columnNames = {"ID", "Nombre", "Apellido1", "Apellido2", "Edad", "Gafas"};
    private List<Persona> data;

    public PersonaTableModel(List<Persona> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        if (data == null)
            return 0;
        return data.size();
    }

    @Override
    public Object getValueAt(int row, int col) {
        Persona persona = data.get(row);
        switch (col) {
            case 0:
                return persona.getId();
            case 1:
                return persona.getNombre();
            case 2:
                return persona.getApellido1();
            case 3:
                return persona.getApellido2();
            case 4:
                return persona.getEdad();
            case 5:
                return persona.isGafas();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    // Hacer que las celdas sean editables
    @Override
    public boolean isCellEditable(int row, int col) {
        return true; // Puedes personalizar qué celdas son editables
    }

    // Actualizar el valor en el modelo de datos
    @Override
    public void setValueAt(Object value, int row, int col) {
        Persona persona = data.get(row);
        switch (col) {
            case 0:
                persona.setId((Integer) value);
                break;
            case 1:
                persona.setNombre((String) value);
                break;
            case 2:
                persona.setApellido1((String) value);
                break;
            case 3:
                persona.setApellido2((String) value);
                break;
            case 4:
                persona.setEdad((Integer) value);
                break;
            case 5:
                persona.setGafas((Boolean) value);
                break;
        }
        fireTableCellUpdated(row, col);
    }

    // Especificar el tipo de datos de cada columna
    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
            case 4:
                return Integer.class;
            case 5:
                return Boolean.class;
            default:
                return String.class;
        }
    }
}
