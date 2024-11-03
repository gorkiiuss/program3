package com.github.gorkiiuss.program3.logging.ejemplojtable.copy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class EjemploJTable {
    // Crea una instancia de Logger para esta clase
    private static final Logger logger = Logger.getLogger(EjemploJTable.class.getName());

    public static void main(String[] args) {
        // Crea un nuevo JFrame con el título "JTable Logging Ejemplo"
        JFrame frame = new JFrame("JTable Logging Ejemplo");

        // Crea un modelo de tabla por defecto
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre");
        model.addColumn("Edad");

        // Crea un JTable con el modelo
        JTable table = new JTable(model);

        // Botón para añadir una nueva fila
        JButton addButton = new JButton("Añadir");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Añade una nueva fila al modelo de la tabla
                model.addRow(new Object[]{"Nuevo", 20});
                // Registra el evento de añadir una fila
                logger.info("Fila añadida");
            }
        });

        // Botón para eliminar la fila seleccionada
        JButton deleteButton = getJButton(table, model);

        // Crea un panel para los botones y los agrega
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);

        // Agrega el JScrollPane con la tabla al centro del frame
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        // Agrega el panel de botones al sur del frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Configura el tamaño y comportamiento de cierre del frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hace visible el frame
        frame.setVisible(true);
    }

    private static JButton getJButton(JTable table, DefaultTableModel model) {
        JButton deleteButton = new JButton("Eliminar");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtiene el índice de la fila seleccionada
                int selectedRow = table.getSelectedRow();
                // Verifica si hay una fila seleccionada
                if (selectedRow != -1) {
                    // Elimina la fila del modelo
                    model.removeRow(selectedRow);
                    // Registra el evento de eliminación de la fila
                    logger.info("Fila eliminada");
                } else {
                    // Registra si no hay una fila seleccionada
                    logger.warning("No se seleccionó ninguna fila para eliminar");
                }
            }
        });
        return deleteButton;
    }
}
