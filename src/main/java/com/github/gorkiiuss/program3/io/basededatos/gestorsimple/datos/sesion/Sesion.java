package com.github.gorkiiuss.program3.io.basededatos.gestorsimple.datos.sesion;

import com.github.gorkiiuss.program3.io.basededatos.gestorsimple.datos.pelicula.Pelicula;

import java.util.Date;

public class Sesion {
    private final int id;
    private Pelicula pelicula;
    private Date diaYHora;
    private int sala;
    private float precio;

    public Sesion(int id, Pelicula pelicula, Date diaYHora, int sala, float precio) {
        this.id = id;
        this.pelicula = pelicula;
        this.diaYHora = diaYHora;
        this.sala = sala;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Date getDiaYHora() {
        return diaYHora;
    }

    public int getSala() {
        return sala;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public void setDiaYHora(Date diaYHora) {
        this.diaYHora = diaYHora;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
