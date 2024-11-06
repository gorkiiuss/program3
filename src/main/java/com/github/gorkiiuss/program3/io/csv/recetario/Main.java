package com.github.gorkiiuss.program3.io.csv.recetario;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Receta[] recetas = GestorCSVRecetario.cargarArchivo();
        if (recetas == null)
            return;

        System.out.println("--- RECETAS CARGADAS ---");
        for (int i = 0; i < recetas.length; i++) {
            Receta receta = recetas[i];
            System.out.println(i + ". " + receta);
        }

        Cocinero cocinero = new Cocinero();
        for (Receta receta : recetas) {
            System.out.println("Receta \"" + receta.getNombre() + "\"");
            cocinero.escribirElaboracionDeReceta(receta);
        }

        System.out.println("--- RECETAS PARA GUARDAR ---");
        for (int i = 0; i < recetas.length; i++) {
            Receta receta = recetas[i];
            System.out.println(i + ". " + receta);
        }

        GestorCSVRecetario.guardarArchivo(recetas);
    }
}
