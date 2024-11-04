package com.github.gorkiiuss.program3.io.lang;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIdioma extends JPanel {
    private final JButton btnEs_ES;
    private final JButton btnEus_EUS;
    private final JButton btnUs_EN;
    private final JButton btnDe_DE;
    private ModeloDeLaVistaPanelIdioma modeloDeLaVista;

    public PanelIdioma(ModeloDeLaVistaPanelIdioma modeloDeLaVista) {
        super(new FlowLayout(FlowLayout.TRAILING, 5, 5));
        this.btnEs_ES = new JButton("Español");
        this.btnEus_EUS = new JButton("Euskera");
        this.btnUs_EN = new JButton("Ingles");
        this.btnDe_DE = new JButton("Aleman");

        this.modeloDeLaVista = modeloDeLaVista;

        btnEs_ES.addActionListener(new Controlador());
        btnEus_EUS.addActionListener(new Controlador());
        btnUs_EN.addActionListener(new Controlador());
        btnDe_DE.addActionListener(new Controlador());

        add(btnEs_ES);
        add(btnEus_EUS);
        add(btnUs_EN);
        add(btnDe_DE);
    }

    private class Controlador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (!(source instanceof JButton btnSource))
                return;

            switch (btnSource.getText()) {
                case "Español" -> modeloDeLaVista.setIdiomaElegido("es_ES");
                case "Euskera" -> modeloDeLaVista.setIdiomaElegido("eus_EUS");
                case "Ingles" -> modeloDeLaVista.setIdiomaElegido("us_EN");
                case "Aleman" -> modeloDeLaVista.setIdiomaElegido("de_DE");
            }
        }

    }
}
