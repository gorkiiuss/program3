package com.github.gorkiiuss.program3.ejercicios.tablaproductos.adrianaramirez;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private JTable tablaProductos;
    private JButton btnAgregar, btnEditar, btnEliminar;

    public VentanaPrincipal() {
        setTitle("Gestión de Inventario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Inicializar componentes
        tablaProductos = new TablaDeProductos(new ArrayList<>());  // El modelo de la tabla se configurará más adelante.
        btnAgregar = new JButton("Agregar Producto");
        btnEditar = new JButton("Editar Producto");
        btnEliminar = new JButton("Eliminar Producto");

        // Configuración del layout
        setLayout(new BorderLayout());
        add(new JScrollPane(tablaProductos), BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);
        add(panelBotones, BorderLayout.SOUTH);

        // Aquí se añadirán los listeners para manejar eventos de los botones.
        
        //AGREGAR -> al darle queremos que salga una nueva ventana emergente:
        btnAgregar.addActionListener(e -> {
        	
        	JPanel ventanaEmergente = new JPanel(new GridLayout(5, 2));
        	
        	JLabel labelID = new JLabel("ID");
        	ventanaEmergente.add(labelID);
        	JTextField textFieldID = new JTextField();
        	ventanaEmergente.add(textFieldID);
        	
        	JLabel labelNombre = new JLabel("Nombre");
        	ventanaEmergente.add(labelNombre);
        	JTextField textFieldNombre = new JTextField();
        	ventanaEmergente.add(textFieldNombre );
        	
        	JLabel labelCantidad = new JLabel("Cantidad");
        	ventanaEmergente.add(labelCantidad);
        	JTextField textFieldCantidad = new JTextField();
        	ventanaEmergente.add(textFieldCantidad );
        	
        	JLabel labelPrecio = new JLabel("Precio");
        	ventanaEmergente.add(labelPrecio);
        	JTextField textFieldPrecio = new JTextField();
        	ventanaEmergente.add(textFieldPrecio );
        	
        	JLabel labelCategoria = new JLabel("Categoria");
        	ventanaEmergente.add(labelCategoria);
        	JTextField textFieldCategoria = new JTextField();
        	ventanaEmergente.add(textFieldCategoria );
        	   	
        	
        	int opcion = JOptionPane.showConfirmDialog(panelBotones, ventanaEmergente);
        	
        	if(opcion == JOptionPane.OK_OPTION) {
        		new Producto(Integer.parseInt(textFieldID.getText()), textFieldNombre.getText(), Integer.parseInt(textFieldCantidad.getText()), Float.parseFloat(textFieldPrecio.getText()), textFieldCategoria.getText());
        	}
        	
        	
        });
        
        //EDITAR -> 
        btnEditar.addActionListener(e -> {
        	
        	tablaProductos.getSelectedRow();
        	
        	
        	
        	
        });
        
        
//        public JPanel getVentanaEmergente() {
//
//        	JPanel ventanaEmergente = new JPanel(new GridLayout(5, 2));
//
//        	ventanaEmergente.add(new JLabel("ID"));
//        	ventanaEmergente.add(new JTextField());
//        	ventanaEmergente.add(new JLabel("Nombre"));
//        	ventanaEmergente.add(new JTextField());
//        	ventanaEmergente.add(new JLabel("Cantidad"));
//        	ventanaEmergente.add(new JTextField());
//        	ventanaEmergente.add(new JLabel("Precio"));
//        	ventanaEmergente.add(new JTextField());
//        	ventanaEmergente.add(new JLabel("Categoria"));
//        	ventanaEmergente.add(new JTextField());
//
//        }
        
    }
}
