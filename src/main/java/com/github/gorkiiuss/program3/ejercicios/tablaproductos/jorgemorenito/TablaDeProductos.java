package com.github.gorkiiuss.program3.ejercicios.tablaproductos.jorgemorenito;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class TablaDeProductos extends JTable {

    private DefaultTableModel modeloTabla;

    public TablaDeProductos(List<Producto> productos) {
        // Configuración básica del JTable con un modelo de tabla
        modeloTabla = new InventarioTableModel(productos);

        // Añadir columnas
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio");
        modeloTabla.addColumn("Categoría");

        // Configurar el JTable con el modelo de tabla
        setModel(modeloTabla);

        // Aquí se añadirá el código para poblar la tabla con los productos
        cargarProductos(productos);
    }

    private void cargarProductos(List<Producto> productos) {
        // Se implementará la lógica para cargar los productos en la tabla
        for (Producto producto : productos) {
            Object[] fila = {
                    producto.getId(),
                    producto.getNombre(),
                    producto.getCantidad(),
                    producto.getPrecio(),
                    producto.getCategoria()
            };
            modeloTabla.addRow(fila);
        }
    }

    // Métodos adicionales como agregar, editar o eliminar productos serán implementados por el alumno
    
    
}
