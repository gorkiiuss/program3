package com.github.gorkiiuss.program3.ejercicios.parcial2023.gorkapuente;

import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    private List<Comic> comics;

    private JTable tablaComics;
    private DefaultTableModel modeloDatosComics;
    private JTable tablaPersonajes;
    private DefaultTableModel modeloDatosPersonajes;
    private JScrollPane scrollPanePersonajes;

    public VentanaPrincipal(List<Comic> comics) {
        //Asignamos la lista de comics a la varaible local
        this.comics = comics;

        //Se inicializan las tablas y sus modelos de datos
        this.initTables();
        //Se cargan los comics en la tabla de comics
        this.loadComics();

        //La tabla de comics se inserta en un panel con scroll
        JScrollPane scrollPaneComics = new JScrollPane(this.tablaComics);
        scrollPaneComics.setBorder(new TitledBorder("Comics"));
        this.tablaComics.setFillsViewportHeight(true);

        //La tabla de personajes se inserta en otro panel con scroll
        this.scrollPanePersonajes = new JScrollPane(this.tablaPersonajes);
        this.scrollPanePersonajes.setBorder(new TitledBorder("Personajes"));
        this.tablaPersonajes.setFillsViewportHeight(true);

        //El Layout del panel principal es un matriz con 2 filas y 1 columna
        this.getContentPane().setLayout(new GridLayout(2, 1));
        this.getContentPane().add(scrollPaneComics);
        this.getContentPane().add(this.scrollPanePersonajes);

        this.setTitle("Ventana principal de Comics");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initTables() {
        //Cabecera del modelo de datos
        Vector<String> cabeceraComics = new Vector<String>(Arrays.asList( "ID", "EDITORIAL", "TÍTULO", "PERSONAJES"));
        //Se crea el modelo de datos para la tabla de comics sólo con la cabecera
        this.modeloDatosComics = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraComics);
        //Se crea la tabla de comics con el modelo de datos
        this.tablaComics = new JTable(this.modeloDatosComics);
        //Se modifica el modelo de selección de la tabla para que se pueda selecciona únicamente una fila
        this.tablaComics.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //Se define el comportamiento el evento de selección de una fila de la tabla
        this.tablaComics.getSelectionModel().addListSelectionListener(e -> {
            //Cuando se selecciona una fila, se actualiza la tabla de personajes
            this.loadPersonajes(this.comics.get((int)tablaComics.getValueAt(tablaComics.getSelectedRow(), 0)-1));
        });
        this.tablaComics.setRowHeight(26);

        //Cabecera del modelo de datos
        Vector<String> cabeceraPersonajes = new Vector<String>(Arrays.asList( "ID", "EDITORIAL", "NOMBRE", "EMAIL"));
        //Se crea el modelo de datos para la tabla de comics sólo con la cabecera
        this.modeloDatosPersonajes = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraPersonajes);
        //Se crea la tabla de personajes con el modelo de datos
        this.tablaPersonajes = new JTable(this.modeloDatosPersonajes);
        this.tablaPersonajes.setRowHeight(26);


        // Asignar renderizadores a las columnas de tablaComics
        for (int i = 0; i < tablaComics.getColumnCount(); i++) {
            String columnName = tablaComics.getColumnName(i);
            if (columnName.equals("ID") || columnName.equals("PERSONAJES")) {
                // Columnas numéricas, alineación al centro
                tablaComics.getColumnModel().getColumn(i).setCellRenderer(new AlignedCellRenderer(SwingConstants.CENTER));
                tablaComics.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.CENTER));
            } else if (columnName.equals("EDITORIAL")) {
                // Columna 'EDITORIAL', asignamos el renderizador personalizado
                tablaComics.getColumnModel().getColumn(i).setCellRenderer(new EditorialCellRenderer());
                tablaComics.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.CENTER));
            } else if (columnName.equals("TÍTULO")) {
                // Columna 'TÍTULO', alineación a la izquierda
                tablaComics.getColumnModel().getColumn(i).setCellRenderer(new AlignedCellRenderer(SwingConstants.LEFT));
                tablaComics.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.LEFT));

                // Establecer el ancho preferido de la columna 'TÍTULO' a 200 píxeles
                tablaComics.getColumnModel().getColumn(i).setPreferredWidth(200);
            } else {
                // Otras columnas de texto, alineación a la izquierda
                tablaComics.getColumnModel().getColumn(i).setCellRenderer(new AlignedCellRenderer(SwingConstants.LEFT));
                tablaComics.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.LEFT));
            }
        }


        // Asignar renderizadores a las columnas de tablaPersonajes
        for (int i = 0; i < tablaPersonajes.getColumnCount(); i++) {
            String columnName = tablaPersonajes.getColumnName(i);
            if (columnName.equals("ID")) {
                // Columna numérica
                tablaPersonajes.getColumnModel().getColumn(i).setCellRenderer(new AlignedCellRenderer(SwingConstants.CENTER));
                tablaPersonajes.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.CENTER));
            } else if (columnName.equals("EDITORIAL")) {
                // Columna 'EDITORIAL'
                tablaPersonajes.getColumnModel().getColumn(i).setCellRenderer(new EditorialCellRenderer());
                tablaPersonajes.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.CENTER));
            } else if (columnName.equals("EMAIL")) {
                // Columna 'EMAIL', alineación a la izquierda
                tablaPersonajes.getColumnModel().getColumn(i).setCellRenderer(new AlignedCellRenderer(SwingConstants.LEFT));
                tablaPersonajes.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.LEFT));

                // Establecer el ancho mínimo de la columna 'EMAIL' a 200 píxeles
                tablaPersonajes.getColumnModel().getColumn(i).setMinWidth(200);

                // Opcional: establecer ancho preferido
                tablaPersonajes.getColumnModel().getColumn(i).setPreferredWidth(200);
            } else {
                // Otras columnas de texto, alineación a la izquierda
                tablaPersonajes.getColumnModel().getColumn(i).setCellRenderer(new AlignedCellRenderer(SwingConstants.LEFT));
                tablaPersonajes.getColumnModel().getColumn(i).setHeaderRenderer(new HeaderRenderer(SwingConstants.LEFT));
            }
        }
    }

    private void loadComics() {
        //Se borran los datos del modelo de datos
        this.modeloDatosComics.setRowCount(0);
        //Se añaden los comics uno a uno al modelo de datos
        this.comics.forEach(c -> this.modeloDatosComics.addRow(
                new Object[] {c.getId(), c.getEditorial(), c.getTitulo(), c.getPersonajes().size()} )
        );
    }

    private void loadPersonajes(Comic comic) {
        //Se borran los datos del modelo de datos
        this.modeloDatosPersonajes.setRowCount(0);

        //Se añaden los personajes uno a uno al modelo de datos
        comic.getPersonajes().forEach(p -> this.modeloDatosPersonajes.addRow(
                new Object[] {p.getId(), p.getEditorial(), p.getNombre(), p.getEmail()} )
        );

        //Se modifica el texto del bode de la lista de personajes
        this.scrollPanePersonajes.setBorder(new TitledBorder(String.format("Personajes del comic '%s' [%d]",
                comic.getTitulo(), comic.getPersonajes().size())));
    }
}