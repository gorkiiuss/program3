package com.github.gorkiiuss.program3.swing.joptionpane.ejemplo;

import javax.swing.*;

public class Ejemplo {
    public static void main(String[] args) {
        // Muestra un cuadro de diálogo de confirmación con opciones Sí y No
        int option = JOptionPane.showConfirmDialog(
                null,
                "¿Deseas continuar?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION
        );

        // Verifica la opción seleccionada por el usuario
        if (option == JOptionPane.YES_OPTION) {
            System.out.println("Usuario seleccionó Sí");
        } else {
            System.out.println("Usuario seleccionó No");
        }
    }
}
