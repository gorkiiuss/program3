package com.github.gorkiiuss.program3.io.lang;

import javax.swing.*;
import java.awt.*;

public class ConsultorMetereologico extends JFrame {
    public ConsultorMetereologico() {
        super("Constructor metereologico");
        setSize(1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        PanelConversacion panelConversacion = new PanelConversacion();
        ModeloDeLaVistaPanelIdioma modeloDeLaVistaPanelIdioma = new ModeloDeLaVistaPanelIdioma();
        modeloDeLaVistaPanelIdioma.addObserver(panelConversacion);
        PanelIdioma panelIdioma = new PanelIdioma(modeloDeLaVistaPanelIdioma);

        add(panelConversacion, BorderLayout.CENTER);
        add(panelIdioma, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        ConsultorMetereologico consultorMetereologico = new ConsultorMetereologico();
        consultorMetereologico.setVisible(true);
    }
}
