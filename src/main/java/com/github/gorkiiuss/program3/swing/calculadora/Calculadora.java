package com.github.gorkiiuss.program3.swing.calculadora;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Este ejemplo ha sigo creado a partir de una versión generada con ChatGPT 4o
public class Calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField display;

    public Calculadora() {
        // Configuración básica de la ventana
        setTitle("Calculadora Básica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // Crear el display de la calculadora
        display = new JTextField();
        display.setEditable(false);                        // No editable
        display.setHorizontalAlignment(JTextField.RIGHT);    // Alineación del texto
        display.setFont(new Font("Arial", Font.PLAIN, 24)); // Formato de la fuente
        add(display, BorderLayout.NORTH);                    // Añadir el display a la ventana

        // Panel de botones numéricos y de operaciones
        JPanel buttonPanel = new JPanel();
        // Definir una cuadrícula de 4x4 con 5 píxeles de separación
        buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));

        // Crear los nombres de los botones
        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            buttonPanel.add(button);

            // Añadir funcionalidad
            button.addActionListener(new Controlador());
        }

        // Añadir el panel de botones al centro de la ventana
        add(buttonPanel, BorderLayout.CENTER);
    }

    // Método principal
    public static void main(String[] args) {
        // Crear una instancia de la calculadora y hacerla visible
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
    }

    private class Controlador implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Obtener los valores del boton que necisitamos
            JButton button = (JButton) e.getSource();
            String textButton = button.getText();

            // Comprobar que no pongamos dos puntos seguidos
            if (textButton.equals(".") && display.getText().charAt(display.getText().length() - 1) == '.') {
                System.out.println("Tas equivocao.");
                return;
            }

            /* TODO 17/10/2024: Comprobar que no pongamos dos operadores seguidos
            *   - Si se hace, lanzar una ventana flotante que indique el error: Mirar en la documentación oficial de
            *     Java sobre JOptionPane y su función showMessageDialog
            *     https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/JOptionPane.html
            * */

            /* TODO 17/10/2024: Añadir también la ventana flotante para el caso anterior */

            if (textButton.matches("[0-9]")
                    || textButton.equals(".")
                    || textButton.matches("[+\\-*/]")
            ) {
                display.setText(display.getText() + textButton);
            } else if (textButton.equals("=")) {
                String aCalcular = display.getText();
                String[] numeros = aCalcular.split("[+\\-*/]");
                String[] operadores = aCalcular.split("[0-9.]");
                String[] operadoresSinEspacios = new String[numeros.length - 1];
                Double[] doubles = new Double[numeros.length];
                for (int i = 0; i < numeros.length; i++) {
                    doubles[i] = Double.parseDouble(numeros[i]);
                }

                int j = 0;
                for (int i = 0; i < operadores.length; i++) {
                    if (!operadores[i].isEmpty()) {
                        operadoresSinEspacios[j] = operadores[i];
                        j++;
                    }
                }

                /* TODO 17/10/2024: Añadir el botón y la función de eliminar la última entrada.*/

                double resultado = doubles[0];
                for (int i = 1; i < doubles.length; i++) {
                    if (operadoresSinEspacios[i - 1].equals("+")) {
                        resultado += doubles[i];
                    } else if (operadoresSinEspacios[i - 1].equals("-")) {
                        resultado -= doubles[i];
                    } else if (operadoresSinEspacios[i - 1].equals("*")) {
                        resultado *= doubles[i];
                    } else if (operadoresSinEspacios[i - 1].equals("/")) {
                        resultado /= doubles[i];
                    }
                }

                display.setText(String.valueOf(resultado));
            }
        }
    }
}