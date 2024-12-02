package com.github.gorkiiuss.program3.io.basededatos.gestorsimple.datos.pelicula;

public class Pelicula {
    private final int id;
    private String titulo;
    private String director;
    private String protagonista;
    private String genero;
    private int duracionEnMinutos;

    public Pelicula(int id, String titulo, String director, String protagonista, String genero, int duracionEnMinutos) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.protagonista = protagonista;
        this.genero = genero;
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDirector() {
        return director;
    }

    public String getProtagonista() {
        return protagonista;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setProtagonista(String protagonista) {
        this.protagonista = protagonista;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", protagonista='" + protagonista + '\'' +
                ", genero='" + genero + '\'' +
                ", duracionEnMinutos=" + duracionEnMinutos +
                '}';
    }
}
