package com.github.gorkiiuss.program3.io.basededatos.gestorsimple.datos.pelicula;

import org.junit.jupiter.api.Test;

class GestorBDPeliculaTest {
    @Test
    public void testObtenerTodasLasPeliculas() {
        for (Pelicula pelicula : GestorBDPelicula.get().obtenerTodasLasPeliculas()) {
            System.out.println(pelicula);
        }
    }
}