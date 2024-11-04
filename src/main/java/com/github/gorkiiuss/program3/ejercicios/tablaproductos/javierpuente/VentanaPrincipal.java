package com.github.gorkiiuss.program3.ejercicios.tablaproductos.javierpuente;

import javax.swing.*;

import com.github.gorkiiuss.program3.ejercicios.tablaproductos.esqueleto.Producto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private JTable tablaProductos;
    private JButton btnAgregar, btnEditar, btnEliminar;

    public VentanaPrincipal() {
        setTitle("Gestión de Inventario");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Inicializar componentes
        tablaProductos = new JTable();  // El modelo de la tabla se configurará más adelante.
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
        
        btnAgregar.addActionListener(e -> {
        	JPanel paneladd = new JPanel(new GridLayout(5,2));
        	JLabel labelid = new JLabel("ID");
        	JLabel labelnombre = new JLabel("Nombre");
        	JLabel labelcantidad = new JLabel("Cantidad");
        	JLabel labelprecio = new JLabel("Precio");
        	JLabel labelcategoria = new JLabel("Categoria");
        	JTextField textfield1 = new JTextField();
        	JTextField textfield2 = new JTextField();
        	JTextField textfield3 = new JTextField();
        	JTextField textfield4 = new JTextField();
        	JTextField textfield5 = new JTextField();

        	paneladd.add(labelid);
        	paneladd.add(textfield1);
        	paneladd.add(labelnombre);
        	paneladd.add(textfield2);
        	paneladd.add(labelcantidad);
        	paneladd.add(textfield3);
        	paneladd.add(labelprecio);
        	paneladd.add(textfield4);
        	paneladd.add(labelcategoria);
        	paneladd.add(textfield5);
        	
        	

        	JOptionPane.showConfirmDialog(panelBotones, paneladd );
        	
        	int option = JOptionPane.YES_NO_CANCEL_OPTION;
        	if(option== 0 ) {
        		Producto prod = new Producto(Integer.parseInt(textfield1.getText()),textfield2.getText(), Integer.parseInt(textfield3.getText()), Double.parseDouble(textfield4.getText()),textfield5.getText());
        		
        	}
        });
    }
}
