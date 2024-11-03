package com.github.gorkiiuss.program3.io.basededatos.datos.pelicula;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestorBDPeliculaTest {
    @Test
    public void testObtenerTodasLasPeliculas() {
        for (Pelicula pelicula : GestorBDPelicula.get().obtenerTodasLasPeliculas()) {
            System.out.println(pelicula);
        }
    }
}