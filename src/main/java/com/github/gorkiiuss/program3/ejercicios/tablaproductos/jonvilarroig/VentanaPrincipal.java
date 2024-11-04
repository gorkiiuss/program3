package com.github.gorkiiuss.program3.ejercicios.tablaproductos.jonvilarroig;

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
        btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel2 =new JPanel();
				JTextField Id = new JTextField();
				JTextField nombre = new JTextField();
				JTextField cantidad = new JTextField();
				JTextField precio = new JTextField();
				JTextField categoria = new JTextField();
				panel2.add(new JLabel("ID"));
				panel2.add(Id);
				panel2.add(new JLabel("nombre"));
				panel2.add(nombre);
				panel2.add(new JLabel("cantidad"));
				panel2.add(cantidad);
				panel2.add(new JLabel("precio"));
				panel2.add(precio);
				panel2.add(new JLabel("categoria"));
				panel2.add(categoria);
				panel2.setLayout(new GridLayout(5,2));
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, panel2 );
				
				Producto p = new Producto(Integer.parseInt(Id.getText()), nombre.getText(), Integer.parseInt(cantidad.getText()), Double.parseDouble(precio.getText()), precio.getText());
				System.out.println(p);
				// tablaProductos;
				}
		});
       
    }
}
