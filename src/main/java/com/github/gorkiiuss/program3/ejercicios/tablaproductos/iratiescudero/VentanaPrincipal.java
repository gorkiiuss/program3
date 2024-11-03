package com.github.gorkiiuss.program3.ejercicios.tablaproductos.iratiescudero;

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
        tablaProductos = new TablaDeProductos(new ArrayList<Producto>());  // El modelo de la tabla se configurará más adelante.
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
        
        btnAgregar.addActionListener(e->{
        	JPanel ventanaemerg= new JPanel ();
        	ventanaemerg.setLayout(new GridLayout(5,2));
        	
        	JLabel id =new JLabel("ID");
        	JTextField idt = new JTextField();
        	ventanaemerg.add(id);
        	ventanaemerg.add(idt);
        	
        	JLabel nombre= new JLabel("Nombre");
        	JTextField nombret = new JTextField();
        	ventanaemerg.add(nombre);
        	ventanaemerg.add(nombret);
        	
        	JLabel cantidad =new JLabel("Cantidad");
        	JTextField cantidadt = new JTextField();
        	ventanaemerg.add(cantidad);
        	ventanaemerg.add(cantidadt);
        	
        	JLabel precio =new JLabel("Precio");
        	JTextField preciot = new JTextField();
        	ventanaemerg.add(precio);
        	ventanaemerg.add(preciot);
        	
        	JLabel categoria =new JLabel("Categoria");
        	JTextField categoriat = new JTextField();
        	ventanaemerg.add(categoria);
        	ventanaemerg.add(categoriat);

        	
        	
        	int opcion= JOptionPane.showConfirmDialog(panelBotones,ventanaemerg);
        	
//        	if (opcion==JOptionPane.OK_OPTION) {
//        		new Producto (Integer.parseInt(idt.getSelectedText()), nombret, cantidadt, preciot, categoriat);
//        	}
        	
        	
        });

        // Aquí se añadirán los listeners para manejar eventos de los botones.
    }
}
