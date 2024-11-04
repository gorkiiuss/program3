package com.github.gorkiiuss.program3.io.basededatos.vista;

import com.github.gorkiiuss.program3.io.basededatos.datos.pelicula.GestorBDPelicula;
import com.github.gorkiiuss.program3.io.basededatos.datos.pelicula.Pelicula;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        super("Cine");
        setSize(1600, 900);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        add(getPnlBotones(), "Botones");

        JButton btnAtrasCartelera = new JButton("<-");
        btnAtrasCartelera.addActionListener(e -> cardLayout.show(this.getContentPane(), "Botones"));


        Pelicula[] peliculas = GestorBDPelicula.get().obtenerTodasLasPeliculas();
        if (peliculas == null)
            throw new RuntimeException("Error cargando base de datos de peliculas");

        ModeloDeLaVistaTablaPeliculas modeloTablaPeliculas = new ModeloDeLaVistaTablaPeliculas(peliculas);
        JPanel pnlPeliculas = getPnlPeliculas(modeloTablaPeliculas);

        add(pnlPeliculas, "Peliculas");

        JPanel pnlCartelera = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlCartelera.add(new JLabel("Tabla de cartelera"));
        pnlCartelera.add(btnAtrasCartelera);

        add(pnlCartelera, "Cartelera");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "¿Quieres guardar los cambios realizados?", "Guardado", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (option) {
                    case JOptionPane.YES_OPTION -> {
                        Pelicula[] peliculas = modeloTablaPeliculas.getPeliculas();
                        GestorBDPelicula.get().guardarTodasLasPeliculas(peliculas);

                        dispose();
                    }
                    case JOptionPane.NO_OPTION -> {
                        dispose();
                    }
                    case JOptionPane.CANCEL_OPTION -> { }
                }
            }
        });
    }

    private JPanel getPnlPeliculas(ModeloDeLaVistaTablaPeliculas modeloTablaPeliculas) {

        TablaPeliculas tablaPeliculas = new TablaPeliculas();
        tablaPeliculas.setModel(modeloTablaPeliculas);

        JButton btnAtrasPeliculas = new JButton("<-");
        btnAtrasPeliculas.addActionListener(e -> cardLayout.show(this.getContentPane(), "Botones"));
        JButton btnAgregarPelicula = new JButton("Añadir pelicula");
        btnAgregarPelicula.addActionListener(e -> modeloTablaPeliculas.nuevaPelicula());
        JButton btnEliminarPelicula = new JButton("Eliminar pelicula");
        btnEliminarPelicula.addActionListener(e -> modeloTablaPeliculas.eliminarPelicula(tablaPeliculas.getSelectedRow()));

        JPanel pnlPeliculas = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlPeliculas.add(new JScrollPane(tablaPeliculas));

        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        pnlBotones.add(btnAgregarPelicula);
        pnlBotones.add(btnEliminarPelicula);
        pnlBotones.add(btnAtrasPeliculas);

        pnlPeliculas.add(pnlBotones);

        tablaPeliculas.setAspecto();

        return pnlPeliculas;
    }

    private JPanel getPnlBotones() {
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JButton btnCartelera = new JButton("Cartelera");
        JButton btnPeliculas = new JButton("Peliculas");

        ActionListener actionListener = e -> {
            if (!(e.getSource() instanceof JButton btn))
                return;

            String btnText = btn.getText();
            cardLayout.show(this.getContentPane(), btnText);
        };

        btnCartelera.addActionListener(actionListener);
        btnPeliculas.addActionListener(actionListener);

        pnlBotones.add(btnCartelera);
        pnlBotones.add(btnPeliculas);

        return pnlBotones;
    }
}
