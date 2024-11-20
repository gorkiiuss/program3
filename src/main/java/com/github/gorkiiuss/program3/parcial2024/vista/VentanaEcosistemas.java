package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.parcial2024.modelo.Ecosistema;

import javax.swing.*;
import java.awt.*;

public class VentanaEcosistemas extends JFrame {
    private final TablaEcosistemas tablaEcosistemas;
    private final JPanel pnlBotones;
    private final JButton botonEmpezar;
    private final JButton botonParar;

    public VentanaEcosistemas(Ecosistema[] ecosistemas) {
        super("Ecosistemas");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TablaEcosistemasModel modelo = new TablaEcosistemasModel(ecosistemas);
        tablaEcosistemas = new TablaEcosistemas(modelo);

        pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));

        botonEmpezar = new JButton("Empezar simulacion");
        botonEmpezar.addActionListener(e -> {

        });

        botonParar = new JButton("Parar simulacion");
        botonParar.addActionListener(e -> {

        });

        pnlBotones.add(botonEmpezar);
        pnlBotones.add(botonParar);

        add(new JScrollPane(tablaEcosistemas), BorderLayout.CENTER);
        add(pnlBotones, BorderLayout.SOUTH);
    }
}
