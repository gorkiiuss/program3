package com.github.gorkiiuss.program3.swing.jtable.ejemplo;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Ejemplo {
    public static void main(String[] args) {
        // Crea un nuevo JFrame con el título "JTable Ejemplo"
        JFrame frame = new JFrame("JTable Ejemplo");

        // Crea un modelo de tabla por defecto y añade columnas
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");

        // Crea un JTable utilizando el modelo creado
        JTable table = new JTable(model);

        // Agrega un TableModelListener al modelo para detectar cambios en los datos de la tabla
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Obtiene el índice de la primera fila afectada por el evento
                int row = e.getFirstRow();
                // Obtiene el índice de la columna afectada por el evento
                int column = e.getColumn();
                // Verifica si la columna es válida (-1 indica que toda la fila ha cambiado)
                if (column != TableModelEvent.ALL_COLUMNS) {
                    // Obtiene el nuevo valor en la celda modificada
                    Object data = model.getValueAt(row, column);
                    // Imprime información sobre el cambio en la consola
                    System.out.println("Cambio en la tabla: Fila " + row + " Columna " + column + " Nuevo valor: " + data);
                } else {
                    // Maneja cambios que afectan a toda la fila o a la estructura de la tabla
                    System.out.println("Cambio en la tabla: Fila " + row + " se ha actualizado toda la fila o estructura.");
                }
            }
        });

        // Agrega filas al modelo de la tabla
        model.addRow(new Object[]{"Juan", 25});
        model.addRow(new Object[]{"Ana", 30});

        // Agrega la tabla dentro de un JScrollPane al frame
        frame.add(new JScrollPane(table));

        JButton boton = new JButton("Añadir");
        boton.addActionListener(e -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(2, 2, 5, 5));
            panel.add(new JLabel("Nombre: "));
            JTextField tfNombre = new JTextField();
            panel.add(tfNombre);
            panel.add(new JLabel("Edad: "));
            JTextField tfEdad = new JTextField();
            panel.add(tfEdad);

            int result = JOptionPane.showConfirmDialog(table, panel, "Añadir", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (JOptionPane.OK_OPTION == result) {
                model.addRow(new Object[] {tfNombre.getText(), Integer.parseInt(tfEdad.getText())});
            } else if (JOptionPane.CANCEL_OPTION == result) {
                // ...
            }
        });

        frame.add(boton, BorderLayout.SOUTH);

        // Configura el tamaño y comportamiento de cierre del frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el frame
        frame.setVisible(true);
    }
}
