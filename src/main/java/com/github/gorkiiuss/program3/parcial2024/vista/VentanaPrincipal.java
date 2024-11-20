package com.github.gorkiiuss.program3.parcial2024.vista;

import com.github.gorkiiuss.program3.parcial2024.Parcial2024;
import com.github.gorkiiuss.program3.parcial2024.modelo.Clima;
import com.github.gorkiiuss.program3.parcial2024.modelo.Ecosistema;
import com.github.gorkiiuss.program3.parcial2024.modelo.Organismo;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        super(Parcial2024.TITULO);
        setLayout(new BorderLayout(20, 20));
        setSize(1080, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ComponentesRutaVista componentesRutaVista = new ComponentesRutaVista();
        ParametrosVista parametrosVista = new ParametrosVista();
        JButton btnCrearEcosistemas = new JButton("Crear ecosistemas");

        btnCrearEcosistemas.addActionListener(e -> {
            Organismo[] organismosPosibles = componentesRutaVista.getOrganismos();
            int numEcosistemas = parametrosVista.getEcosistemas();
            int numOrganismosXEcosistema = parametrosVista.getOrganismos();
            Ecosistema[] ecosistemas = new Ecosistema[numEcosistemas];
            Random random = new Random();
            for (int i = 0; i < ecosistemas.length; i++) {
                Clima[] climas = Clima.values();
                Clima climaAleatorio = climas[random.nextInt(climas.length)];

                Organismo[] organismos = new Organismo[numOrganismosXEcosistema];
                for (int j = 0; j < numOrganismosXEcosistema; j++) {
                    organismos[j] = organismosPosibles[random.nextInt(organismosPosibles.length)];
                }

                float aguaAleatoria = 10_000.0f + random.nextFloat() * 10_000.0f;
                if (aguaAleatoria > 20_000.0f) {
                    aguaAleatoria = 20_000.0f;
                }

                ecosistemas[i] = new Ecosistema(
                        i,
                        "Ecosistema nº " + (i + 1),
                        climaAleatorio,
                        organismos,
                        aguaAleatoria
                );
            }

            new VentanaEcosistemas(ecosistemas).setVisible(true);
        });

        add(componentesRutaVista, BorderLayout.NORTH);
        add(new JScrollPane(parametrosVista), BorderLayout.CENTER);
        add(btnCrearEcosistemas, BorderLayout.SOUTH);
    }
}
