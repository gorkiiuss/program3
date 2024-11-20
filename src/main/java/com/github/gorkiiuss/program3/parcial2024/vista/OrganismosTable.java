package com.github.gorkiiuss.program3.parcial2024.vista;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class OrganismosTable extends JTable {
    public OrganismosTable(OrganismosTableModel organismosTableModel) {
        super(organismosTableModel);
        getColumnModel().getColumns().asIterator()
                .forEachRemaining(tableColumn -> tableColumn.setCellRenderer(new OrganismoCellRenderer()));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == 'd' && getSelectedRow() != -1) {
                    organismosTableModel.addOrganismo(organismosTableModel.getData().duplicate(getSelectedRow()));
                }
            }
        });
    }
}
