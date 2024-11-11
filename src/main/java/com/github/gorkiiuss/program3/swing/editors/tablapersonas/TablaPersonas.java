package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TablaPersonas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Person Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una lista de personas
        List<Persona> persons = new ArrayList<>();
        persons.add(new Persona(1, "Juan", "Pérez", "García", 30, true));
        persons.add(new Persona(2, "María", "López", "Martínez", 25, false));
        persons.add(new Persona(3, "Carlos", "Sánchez", "Rodríguez", 40, true));
        persons.add(new Persona(4, "Ana", "Gómez", "Fernández", 35, false));

        // Crear el modelo de tabla y el JTable
        PersonaTableModel model = new PersonaTableModel(persons);
        JTable table = new JTable(model);

        // Configurar el editor para la columna 'Gafas' como JCheckBox
        table.getColumnModel().getColumn(5).setCellEditor(new BooleanCellEditor());

        // Configurar el renderizador para la columna 'Gafas' como JCheckBox
        table.getColumnModel().getColumn(5).setCellRenderer(new TableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                checkBox.setHorizontalAlignment(JLabel.CENTER);

                return checkBox;
            }
        });

        // Ajustar el ancho de las columnas
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Añadir la tabla al frame
        frame.add(new JScrollPane(table));

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
