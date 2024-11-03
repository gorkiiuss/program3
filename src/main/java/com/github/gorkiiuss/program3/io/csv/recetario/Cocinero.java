package com.github.gorkiiuss.program3.io.csv.recetario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cocinero {
    public void escribirElaboracionDeReceta(Receta receta) throws IOException {
        System.out.println("Introduce la elaboracion de la receta");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String linea;
        StringBuilder descripcionDeLaElaboracion = new StringBuilder();
        do {
            linea = reader.readLine();
            descripcionDeLaElaboracion.append(linea).append("\n");
        } while(!linea.isEmpty());

        receta.setDescripcionDeLaElaboracion(descripcionDeLaElaboracion.toString());
    }
}
