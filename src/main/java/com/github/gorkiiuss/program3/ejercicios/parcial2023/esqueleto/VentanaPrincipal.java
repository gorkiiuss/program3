package com.github.gorkiiuss.program3.ejercicios.parcial2023.esqueleto;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
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

   //Renderizar las filas pares e impares con un color de fondo específico: RGB(250, 249, 249) y RGB(190, 227, 219) respectivamente    
        for(int i=0; i<4; i++) {
        	if(i ==1) {
        		this.tablaComics.getColumnModel().getColumn(1).setCellRenderer(new EditorialCellRenderer());
        	}else this.tablaComics.getColumnModel().getColumn(i).setCellRenderer(new AlternatingRowRenderer());
        }
        
   //CAMBIAMOS LOS NOMBRE DC Y MARVEL POR EL LOGO EN LA TABLA COMICS:
        //lo metemos en el for
        //this.tablaComics.getColumnModel().getColumn(1).setCellRenderer(new EditorialCellRenderer());
        
   //CAMBIAMOS ALTURA DE TODAS LAS FILAS A 26 PIXELES:
        this.tablaComics.setRowHeight(26);
       
        
        
        //Cabecera del modelo de datos
        Vector<String> cabeceraPersonajes = new Vector<String>(Arrays.asList( "ID", "EDITORIAL", "NOMBRE", "EMAIL"));
        //Se crea el modelo de datos para la tabla de comics sólo con la cabecera
        this.modeloDatosPersonajes = new DefaultTableModel(new Vector<Vector<Object>>(), cabeceraPersonajes);
        //Se crea la tabla de personajes con el modelo de datos
        this.tablaPersonajes = new JTable(this.modeloDatosPersonajes);
      
   //CAMBIAMOS LOS NOMBRES POR EL LOGO EN LA TABLA PERSONAJES:     
            
        this.tablaPersonajes.getColumnModel().getColumn(1).setCellRenderer(new EditorialCellRenderer());
        
   //CAMBIAMOS ALTURA DE TODAS LAS FILAS A 26 PIXELES:
        this.tablaPersonajes.setRowHeight(26);
        
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