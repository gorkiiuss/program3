package com.github.gorkiiuss.program3.swing.jtextfield.ejemplo;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Ejemplo {
    public static void main(String[] args) {
        // Crea un nuevo JFrame con el título "JTextField Ejemplo"
        JFrame frame = new JFrame("JTextField Ejemplo");

        // Crea un JTextField con un ancho de 20 columnas
        JTextField textField = new JTextField(20);

        // Agrega un DocumentListener al documento del textField
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                // Se llama cuando se inserta texto
                System.out.println("Texto insertado: " + textField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                // Se llama cuando se elimina texto
                System.out.println("Texto eliminado: " + textField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // Se llama cuando hay cambios en los atributos del texto (no común en JTextField)
                System.out.println("Texto cambiado: " + textField.getText());
            }
        });

        // Agrega el textField al frame
        frame.add(textField);

        // Configura el tamaño y comportamiento de cierre del frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el frame
        frame.setVisible(true);
    }
}
