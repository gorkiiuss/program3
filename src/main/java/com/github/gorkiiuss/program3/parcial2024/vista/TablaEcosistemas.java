package com.github.gorkiiuss.program3.parcial2024.vista;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TablaEcosistemas extends JTable {
    public TablaEcosistemas(TablaEcosistemasModel modelo) {
        super(modelo);
        this.getColumnModel().getColumn(2).setCellRenderer(new AguaCellRenderer());
        this.getColumnModel().getColumn(3).setCellRenderer(new ClimaCellRenderer());
        this.setRowHeight(35);

        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                System.out.println(modelo.getValueAt(rowAtPoint(e.getPoint()), 3));
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Ecosistemas");
            }
        });
    }
}
