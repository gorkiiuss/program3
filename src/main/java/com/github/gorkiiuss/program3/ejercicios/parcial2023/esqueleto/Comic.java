package com.github.gorkiiuss.program3.ejercicios.parcial2023.esqueleto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comic {

    private int id;
    private Personaje.Editorial editorial;
    private String titulo;
    private List<Personaje> personajes;

    public Comic(int id, Personaje.Editorial editorial, String titulo) {
        super();
        this.id = id;
        this.editorial = editorial;
        this.titulo = titulo;

        this.personajes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personaje.Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Personaje.Editorial editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void addPersonaje(Personaje personaje) {
        if (personaje != null && !this.personajes.contains(personaje)) {
            personajes.add(personaje);
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer(String.format("[%-6s] %d - %s", editorial, id, titulo));

        for(Personaje p : personajes) {
            buffer.append(String.format("\n  # %s", p));
        }

        return buffer.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comic other = (Comic) obj;
        return id == other.id;
    }
}