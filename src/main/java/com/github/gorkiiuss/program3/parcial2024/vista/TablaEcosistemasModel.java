package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.parcial2024.modelo.Ecosistema;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class TablaEcosistemasModel extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = new String[]{"ID", "NOMBRE", "AGUA", "CLIMA"};
    private final ArrayList<Ecosistema> ecosistemas;

    public TablaEcosistemasModel(Ecosistema[] ecosistemas) {
        this.ecosistemas = new ArrayList<>(List.of(ecosistemas));
    }

    @Override
    public int getRowCount() {
        if (ecosistemas == null) return 0;
        return ecosistemas.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 2 && column != 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Ecosistema ecosistema = ecosistemas.get(row);
        switch (column) {
            case 0:
                return ecosistema.getID();
            case 1:
                return ecosistema.getNombre();
            case 2:
                return ecosistema.getAgua();
            case 3:
                return ecosistema.getClima();
            default:
                return null;
        }
    }


}
