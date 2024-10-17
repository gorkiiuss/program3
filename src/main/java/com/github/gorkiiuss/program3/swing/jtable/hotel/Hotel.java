package com.github.gorkiiuss.program3.swing.jtable.hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;

public class Hotel {
    public static void main(String[] args) {
        Object[][] inquilinos = {
                {"Juan", "Pérez", 30, "Perro", 101, false},
                {"María", "Gómez", 28, "Gato", 102, true},
                {"Carlos", "Ramírez", 45, "Dragón", 103, false},
                {"Ana", "López", 33, "Pingüino", 104, false},
                {"Pedro", "Sánchez", 40, "Unicornio", 105, true},
                {"Lucía", "Martínez", 25, "Koala", 106, false},
                {"Raúl", "Fernández", 50, "Tortuga", 107, false},
                {"Sofía", "Díaz", 35, "Gato", 108, true},
        };

        String[] nombresDeColumna =
                {"Nombre", "Apellidos", "Edad", "Mascota", "Número de la habitación", "¿Es pelirrojo?"};

        JFrame frame = new JFrame();
        frame.setTitle("Hotel");
        frame.setSize(1000, 500);

        JTable table = new JTable(inquilinos, nombresDeColumna);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        JButton button = new JButton("Imprimir");
        button.addActionListener((e) -> {
            try {
                table.print();
            } catch (PrinterException ex) {
                System.err.println("No hay ninguna impresora");
            }
        });

        frame.add(button, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
