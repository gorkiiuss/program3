package com.github.gorkiiuss.program3.ejercicios.tablaproductos.gorkapuente;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class InventarioTableModel extends DefaultTableModel {
    private List<Producto> productos;

    // Constructor e implementación de métodos requeridos por AbstractTableModel
    public InventarioTableModel(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public int getRowCount() {
        if (productos == null)
            return 0;

        // Devuelve la cantidad de productos
        return productos.size();
    }

    @Override
    public int getColumnCount() {
        // Devuelve la cantidad de columnas de la tabla
        return 5;  // ID, Nombre, Cantidad, Precio, Categoría
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Devuelve el valor en la posición [rowIndex, columnIndex]
        Producto producto = productos.get(rowIndex);
        switch (columnIndex) {
            case 0: return producto.getId();
            case 1: return producto.getNombre();
            case 2: return producto.getCantidad();
            case 3: return producto.getPrecio();
            case 4: return producto.getCategoria();
            default: return null;
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
        fireTableRowsInserted(productos.size() - 1, productos.size() - 1);
    }

    public Producto getProducto(int indice) {
        return this.productos.get(indice);
    }

    public void editarProducto(int indice) {
        fireTableRowsUpdated(indice, indice);
    }

    public void eliminarProducto(int indice) {
        this.productos.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    // Otros métodos, como setValueAt, agregar o eliminar productos serán implementados por el alumno.
}
