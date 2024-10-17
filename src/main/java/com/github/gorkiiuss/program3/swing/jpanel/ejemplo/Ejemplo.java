package com.github.gorkiiuss.program3.swing.jpanel.ejemplo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejemplo {
    public static void main(String[] args) {
        // Crea un nuevo JFrame con el título "CardLayout Ejemplo"
        JFrame frame = new JFrame("CardLayout Ejemplo");

        // Crea un JPanel con un CardLayout
        JPanel panel = new JPanel(new CardLayout());

        // Crea dos botones que representarán dos paneles diferentes
        JButton btn1 = new JButton("Panel 1");
        JButton btn2 = new JButton("Panel 2");

        // Botón para cambiar entre los paneles
        JButton switchBtn = new JButton("Cambiar Panel");

        // Agrega los botones al panel con identificadores únicos
        panel.add(btn1, "Panel 1");
        panel.add(btn2, "Panel 2");

        // Agrega un ActionListener al botón de cambio
        switchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el layout del panel y pasa al siguiente componente
                CardLayout cl = (CardLayout) (panel.getLayout());
                cl.next(panel);
            }
        });

        // Agrega el panel al centro del frame y el botón de cambio al sur
        frame.add(panel, BorderLayout.CENTER);
        frame.add(switchBtn, BorderLayout.SOUTH);

        // Configura el tamaño y comportamiento de cierre del frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el frame
        frame.setVisible(true);
    }
}
