package com.github.gorkiiuss.program3.swing.jframe.ejemplo;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ejemplo {
    public static void main(String[] args) {
        // Crea una nueva instancia de JFrame con el título "Mi ventana"
        JFrame frame = new JFrame("Mi ventana");

        // Establece el tamaño de la ventana a 400 píxeles de ancho y 300 de alto
        frame.setSize(400, 300);

        // Define la operación por defecto al cerrar la ventana (salir de la aplicación)
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Agrega un WindowListener para capturar eventos de la ventana
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Imprime un mensaje en la consola cuando la ventana se está cerrando
                System.out.println("La ventana se está cerrando");
            }
        });

        // Hace que la ventana sea visible
        frame.setVisible(true);
    }
}
