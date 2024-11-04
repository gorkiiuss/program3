package com.github.gorkiiuss.program3.io.csv.recetario;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Receta {
    private final int id;
    private final String nombre;
    private final int comensales;
    private final int duracionEnMinutos;
    private final Ingrediente[] ingredientes;

    private String descripcionDeLaElaboracion;

    public Receta(int id, String nombre, int comensales, int duracionEnMinutos, Ingrediente[] ingredientes) {
        this.id = id;
        this.nombre = nombre;
        this.comensales = comensales;
        this.duracionEnMinutos = duracionEnMinutos;
        this.ingredientes = ingredientes;
    }

    public void setDescripcionDeLaElaboracion(String descripcionDeLaElaboracion) {
        this.descripcionDeLaElaboracion = descripcionDeLaElaboracion;
    }

    public String toCSV() {
        return id + "," + nombre + "," + comensales + "," + duracionEnMinutos + "," +
                Arrays.stream(ingredientes).map(ingrediente -> ingrediente.toCSV() + ",").collect(Collectors.joining())
                + descripcionDeLaElaboracion;
    }

    @Override
    public String toString() {
        String cabecera = "Receta nº " + id + ": " + nombre;
        String informacion = "Receta para " + comensales + " comensal(es) y de " + duracionEnMinutos + " minuto(s) de duracion.";
        String ingredientes = "";
        for (int i = 0; i < this.ingredientes.length; i++) {
            ingredientes += i + ". " + this.ingredientes[i] + "\n";
        }
        return cabecera + "\n" + informacion + "\nIngredientes:\n" + ingredientes + "\nElaboracion:\n" + descripcionDeLaElaboracion;
    }

    public String getNombre() {
        return nombre;
    }
}
