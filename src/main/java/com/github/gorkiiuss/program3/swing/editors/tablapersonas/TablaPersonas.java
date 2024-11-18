package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TablaPersonas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Person Table Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear una lista de personas
        List<Persona> persons = new ArrayList<>();
        persons.add(new Persona(1, "Juan", "Pérez", "García", 30, true, LocalDate.of(2010, 5, 23)));
        persons.add(new Persona(2, "María", "López", "Martínez", 25, false, LocalDate.of(2010, 5, 23)));
        persons.add(new Persona(3, "Carlos", "Sánchez", "Rodríguez", 40, true, LocalDate.of(2010, 5, 23)));
        persons.add(new Persona(4, "Ana", "Gómez", "Fernández", 35, false, LocalDate.of(2010, 5, 23)));

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

        table.getColumnModel().getColumn(6).setCellEditor(new LocalDateEditor());

        // Ajustar el ancho de las columnas
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        // Añadir la tabla al frame
        frame.add(new JScrollPane(table));

        frame.pack();
        frame.setLocationRelativeTo(null);

        // Key Listener
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("Se ha metido");
                if ('a' == e.getKeyChar()) model.add(new Persona(model.getRowCount() + 1));
            }
        });

        frame.setFocusable(true);
        frame.requestFocusInWindow();

        frame.setVisible(true);

        new AnimacionMoverse(frame).start();
        JFrame frame2 = new JFrame("Ventana secundaria");
        frame2.setSize(100, 100);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        new AnimacionMoverse(frame2).start();

        frame2.setVisible(true);
    }
}
