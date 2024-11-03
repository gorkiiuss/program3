package com.github.gorkiiuss.program3.ejercicios.tablaproductos.ikermorrondo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaPrincipal extends JFrame {
    private TablaDeProductos tablaProductos;
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
        
        btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel();
				JOptionPane pane = new JOptionPane();
				panel.setLayout(new GridLayout(5,2));
				
				JTextField Id = new JTextField();
				JTextField Nombre = new JTextField();
				JTextField Cantidad = new JTextField();
				JTextField Precio = new JTextField();
				JTextField Categoria = new JTextField();

				
				panel.add(new JLabel("ID"));
				panel.add(Id);
				
				panel.add(new JLabel("Nombre"));
				panel.add(Nombre);
				
				panel.add(new JLabel("Cantidad"));
				panel.add(Cantidad);
				
				panel.add(new JLabel("Precio"));
				panel.add(Precio);
				
				panel.add(new JLabel("Categoria"));
				panel.add(Categoria);
				
				Producto producto = new Producto(
						Integer.parseInt(Id.getText()), 
						Nombre.getText(), 
						Integer.parseInt(Cantidad.getText()),
						Double.parseDouble(Precio.getText()), 
						Categoria.getText()
						);

				
				pane.showMessageDialog(VentanaPrincipal.this, panel,"Añadir", JOptionPane.YES_NO_OPTION);
				
				
			}
		});
    }
}
