package com.github.gorkiiuss.program3.io.basededatos.vista;

import com.github.gorkiiuss.program3.io.basededatos.datos.pelicula.Pelicula;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModeloDeLaVistaTablaPeliculas extends DefaultTableModel {
    private final List<Pelicula> peliculas = new ArrayList<>();
    private int lastId;

    public ModeloDeLaVistaTablaPeliculas(Pelicula[] peliculas) {
        this.peliculas.addAll(List.of(peliculas));
        addColumn("ID");
        addColumn("TITULO");
        addColumn("DIRECTOR");
        addColumn("PROTAGONISTA");
        addColumn("GENERO");
        addColumn("DURACION EN MINS");

        this.lastId = Arrays.stream(peliculas).mapToInt(Pelicula::getId).max().orElse(1);
    }

    @Override
    public int getRowCount() {
        if (peliculas == null)
            return 0;

        return this.peliculas.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Pelicula pelicula = peliculas.get(row);
        return switch (column) {
            case 0 -> pelicula.getId();
            case 1 -> pelicula.getTitulo();
            case 2 -> pelicula.getDirector();
            case 3 -> pelicula.getProtagonista();
            case 4 -> pelicula.getGenero();
            case 5 -> pelicula.getDuracionEnMinutos();
            default -> throw new IllegalStateException("Unexpected value: columna " + column);
        };
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column != 0;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        Pelicula pelicula = this.peliculas.get(row);
        if (!(aValue instanceof String valueStr))
            return;

        switch (column) {
            case 1 -> pelicula.setTitulo(valueStr);
            case 2 -> pelicula.setDirector(valueStr);
            case 3 -> pelicula.setProtagonista(valueStr);
            case 4 -> pelicula.setGenero(valueStr);
            case 5 -> pelicula.setDuracionEnMinutos(Integer.parseInt(valueStr));
        }
    }

    public Pelicula[] getPeliculas() {
        return this.peliculas.toArray(new Pelicula[0]);
    }

    public void nuevaPelicula() {
        this.peliculas.add(new Pelicula(++this.lastId, "", "", "", "", 0));
        fireTableRowsInserted(this.peliculas.size() - 1, this.peliculas.size() - 1);
    }

    public void eliminarPelicula(int selectedRow) {
        if (selectedRow == -1)
            return;

        this.peliculas.remove(selectedRow);
        fireTableRowsDeleted(selectedRow, selectedRow);
    }
}
