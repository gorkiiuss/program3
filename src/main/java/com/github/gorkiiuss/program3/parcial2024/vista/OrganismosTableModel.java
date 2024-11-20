package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.parcial2024.modelo.*;

import javax.swing.table.DefaultTableModel;

public class OrganismosTableModel extends DefaultTableModel {
    private static final String[] COLUMN_NAMES = new String[] {"ID", "NOMBRE"};
    private final ListaDeOrganismos data = new ListaDeOrganismos();

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public int getRowCount() {
        if (data == null)
            return 0;

        return data.size();
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
    public Object getValueAt(int row, int column) {
        Organismo organismo = data.get(row);
        switch (column) {
            case 0:
                return organismo.getID();
            case 1:
                return organismo.getNombre();
            default:
                return null;
        }
    }

    public void setData(Organismo[] data) {
        this.data.setLista(data);
        fireTableDataChanged();
    }

    public ListaDeOrganismos getData() {
        return data;
    }

    public void addOrganismo(Organismo organismo) {
        this.data.add(organismo);
        fireTableDataChanged();
    }

    public void addOrganismo(String tipo, String nombre) {
        if (tipo.equals(Planta.class.getSimpleName())) addOrganismo(new Planta(data.getAvaliableIdx(), nombre));
        else if (tipo.equals(Herviboro.class.getSimpleName())) addOrganismo(new Herviboro(data.getAvaliableIdx(), nombre));
        else if (tipo.equals(Carnivoro.class.getSimpleName())) addOrganismo(new Carnivoro(data.getAvaliableIdx(), nombre));
    }

    public void updateOrganismo(int idx) {
        fireTableRowsUpdated(idx, idx);
    }

    public void deleteOrganismo(int idx) {
        this.data.remove(idx);
        fireTableRowsDeleted(idx, idx);
    }

    public void clear() {
        this.data.clear();
        fireTableDataChanged();
    }
}
