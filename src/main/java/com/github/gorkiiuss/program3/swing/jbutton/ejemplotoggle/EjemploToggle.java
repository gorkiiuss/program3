package com.github.gorkiiuss.program3.swing.jbutton.ejemplotoggle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjemploToggle {
    public static void main(String[] args) {
        // Crea un nuevo JFrame con el título "JToggleButton Ejemplo"
        JFrame frame = new JFrame("JToggleButton Ejemplo");

        // Obtiene el JToggleButton configurado mediante un método separado
        JToggleButton toggleButton = getJToggleButton();

        // Agrega el toggleButton al frame
        frame.add(toggleButton);

        // Configura el tamaño y comportamiento de cierre del frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el frame
        frame.setVisible(true);
    }

    /**
     * Crea y configura un JToggleButton.
     * <p>
     * Se extrae la creación y configuración del JToggleButton a este método para mejorar la legibilidad
     * y modularidad del código. Al hacerlo:
     * - Se mantiene el método main más limpio y enfocado en la estructura general de la aplicación.
     * - Se facilita el mantenimiento y posible reutilización del botón en otras partes del código.
     * - Se mejora la organización al separar la lógica de creación de componentes de la lógica de presentación.
     *
     * @return un JToggleButton configurado con su ActionListener.
     */
    private static JToggleButton getJToggleButton() {
        // Crea un JToggleButton con el texto "Encendido/Apagado"
        JToggleButton toggleButton = new JToggleButton("Encendido/Apagado");

        // Agrega un ActionListener para manejar los cambios de estado del botón
        toggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Verifica si el botón está seleccionado (encendido) o no (apagado)
                if (toggleButton.isSelected()) {
                    System.out.println("Botón encendido");
                } else {
                    System.out.println("Botón apagado");
                }
            }
        });

        // Retorna el JToggleButton configurado
        return toggleButton;
    }
}
