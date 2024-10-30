package com.github.gorkiiuss.program3.ejercicios.tablaproductos.jorgemorenito;

import javax.swing.*;
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
			
			JPanel panel = new JPanel(new GridLayout(5, 2));

			JLabel label1 = new JLabel("ID");
			panel.add(label1);

			JTextField texto1 = new JTextField();
			panel.add(texto1);

			JLabel label2 = new JLabel("Nombre");
			panel.add(label2);

			JTextField texto2 = new JTextField();
			panel.add(texto2);

			JLabel label3 = new JLabel("Cantidad");
			panel.add(label3);

			JTextField texto3 = new JTextField();
			panel.add(texto3);

			JLabel label4 = new JLabel("Precio");
			panel.add(label4);

			JTextField texto4 = new JTextField();
			panel.add(texto4);

			JLabel label5 = new JLabel("Categoria");
			panel.add(label5);

			JTextField texto5 = new JTextField();
			panel.add(texto5);


			JOptionPane.showConfirmDialog(panelBotones, panel);

			int option = JOptionPane.YES_NO_OPTION;
			if(option == 0) {

				Producto producto = new Producto(Integer.parseInt(texto1.getText()), texto2.getText(), Integer.parseInt(texto3.getText()), Double.parseDouble(texto4.getText()), texto5.getText());



			}


		});

	}
}
