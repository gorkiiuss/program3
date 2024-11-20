package com.github.gorkiiuss.program3.parcial2024.modelo;

import java.util.ArrayList;
import java.util.List;

public class Ecosistema {
    private final int id;
    private String nombre;
    private final Clima clima;
    private float agua;
    private final ArrayList<Organismo> organismo;

    public Ecosistema(int id, String nombre, Clima clima, Organismo[] organismo, float agua) {
        this.id = id;
        this.nombre = nombre;
        this.clima = clima;
        this.organismo = new ArrayList<>(List.of(organismo));
        this.agua = agua;
    }

    public int getID() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public float getAgua() {
        return this.agua;
    }

    public Clima getClima() {
        return this.clima;
    }

    @Override
    public String toString() {
        return "Ecosistema{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", clima=" + clima +
                ", agua=" + agua +
                ", organismo=" + organismo +
                '}';
    }
}
