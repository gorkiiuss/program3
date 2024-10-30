package com.github.gorkiiuss.program3.ejercicios.tablaproductos.gorkapuente;

import javax.swing.*;
import java.awt.*;
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
        btnAgregar.addActionListener(e -> {
            JPanel panel = new JPanel(new GridLayout(5, 2));

            JLabel lblID = new JLabel("ID: ");
            JTextField tfID = new JTextField();
            JLabel lblNombre = new JLabel("Nombre: ");
            JTextField tfNombre = new JTextField();
            JLabel lblCantidad = new JLabel("Cantidad: ");
            JTextField tfCantidad = new JTextField();
            JLabel lblPrecio = new JLabel("Precio: ");
            JTextField tfPrecio = new JTextField();
            JLabel lblCategoria = new JLabel("Categoria: ");
            JTextField tfCategoria = new JTextField();

            panel.add(lblID); panel.add(tfID);
            panel.add(lblNombre); panel.add(tfNombre);
            panel.add(lblCantidad); panel.add(tfCantidad);
            panel.add(lblPrecio); panel.add(tfPrecio);
            panel.add(lblCategoria); panel.add(tfCategoria);

            int option = JOptionPane.showConfirmDialog(
                    null, panel, "Agregar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (option == JOptionPane.OK_OPTION) {
                Producto producto = new Producto(
                        Integer.parseInt(tfID.getText()),
                        tfNombre.getText(),
                        Integer.parseInt(tfCantidad.getText()),
                        Float.parseFloat(tfPrecio.getText()),
                        tfCategoria.getText()
                );

                tablaProductos.getModeloTabla().agregarProducto(producto);
            } else if (option == JOptionPane.CANCEL_OPTION) {

            }
        });

        btnEditar.addActionListener(e -> {
            int filaSeleccionada = tablaProductos.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Selecciona un producto para poder editarlo!",
                        "Error", JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            Producto productoSeleccionado = tablaProductos.getModeloTabla().getProducto(filaSeleccionada);

            JPanel panel = new JPanel(new GridLayout(5, 2));

            JLabel lblID = new JLabel("ID: ");
            JTextField tfID = new JTextField(String.valueOf(productoSeleccionado.getId()));
            JLabel lblNombre = new JLabel("Nombre: ");
            JTextField tfNombre = new JTextField(productoSeleccionado.getNombre());
            JLabel lblCantidad = new JLabel("Cantidad: ");
            JTextField tfCantidad = new JTextField(String.valueOf(productoSeleccionado.getCantidad()));
            JLabel lblPrecio = new JLabel("Precio: ");
            JTextField tfPrecio = new JTextField(String.valueOf(productoSeleccionado.getPrecio()));
            JLabel lblCategoria = new JLabel("Categoria: ");
            JTextField tfCategoria = new JTextField(productoSeleccionado.getCategoria());

            panel.add(lblID); panel.add(tfID);
            panel.add(lblNombre); panel.add(tfNombre);
            panel.add(lblCantidad); panel.add(tfCantidad);
            panel.add(lblPrecio); panel.add(tfPrecio);
            panel.add(lblCategoria); panel.add(tfCategoria);

            int option = JOptionPane.showConfirmDialog(
                    null, panel, "Editar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
            );

            if (option == JOptionPane.OK_OPTION) {
                productoSeleccionado.setId(Integer.parseInt(tfID.getText()));
                productoSeleccionado.setNombre(tfNombre.getText());
                productoSeleccionado.setCantidad(Integer.parseInt(tfCantidad.getText()));
                productoSeleccionado.setPrecio(Double.parseDouble(tfPrecio.getText()));
                productoSeleccionado.setCategoria(tfCategoria.getText());

                tablaProductos.getModeloTabla().editarProducto(filaSeleccionada);
            } else if (option == JOptionPane.CANCEL_OPTION) {

            }
        });

        btnEliminar.addActionListener(e -> {
            int filaSeleccionada = tablaProductos.getSelectedRow();
            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Selecciona un producto para poder eliminarlo!",
                        "Error", JOptionPane.ERROR_MESSAGE
                );
                return;
            }

            tablaProductos.getModeloTabla().eliminarProducto(filaSeleccionada);
        });
    }
}
