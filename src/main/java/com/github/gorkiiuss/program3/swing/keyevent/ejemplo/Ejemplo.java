package com.github.gorkiiuss.program3.swing.keyevent.ejemplo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ejemplo {
    public static void main(String[] args) {
        // Crea un nuevo JFrame con el título "JTable KeyListener Ejemplo"
        JFrame frame = new JFrame("JTable KeyListener Ejemplo");

        // Crea un modelo de tabla por defecto y agrega columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");

        // Agrega filas al modelo de la tabla
        model.addRow(new Object[]{"Juan", 25});
        model.addRow(new Object[]{"Ana", 30});

        // Crea un JTable con el modelo creado
        JTable table = getJTable(model);

        // Agrega la tabla dentro de un JScrollPane al frame
        frame.add(new JScrollPane(table));

        // Configura el tamaño y comportamiento de cierre del frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el frame
        frame.setVisible(true);
    }

    private static JTable getJTable(DefaultTableModel model) {
        JTable table = new JTable(model);

        // Agrega un KeyListener al JTable para detectar pulsaciones de teclas
        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Verifica si la tecla presionada es 'p'
                if (e.getKeyChar() == 'p') {
                    try {
                        // Intenta imprimir la tabla
                        table.print();
                    } catch (Exception ignore) {

                    }
                }else if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                	System.exit(0);
                }
            }
        });
        return table;
    }
}
