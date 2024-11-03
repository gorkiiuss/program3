package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.iorenderers.esqueleto;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public Window() {
        super("IO Renderers");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Añadir tabla de numeros
        NumberTableModel tableModel = new NumberTableModel(9);
        NumberTable numberTable = new NumberTable(tableModel);

        add(new JScrollPane(numberTable), BorderLayout.CENTER);

        // Añadir boton de añadir fila
        JPanel pnlBtns = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnAdd = new JButton("Añadir fila");
        btnAdd.addActionListener(e -> tableModel.addRow());

        pnlBtns.add(btnAdd);

        // Añadir boton de mostrar imagenes
        JToggleButton btnShow = new JToggleButton("Mostrar imagenes");
        btnShow.addActionListener(e -> tableModel.setShowing(btnShow.isSelected()));

        pnlBtns.add(btnShow);

        // Añadir panel de botones
        add(pnlBtns, BorderLayout.SOUTH);
    }
}
