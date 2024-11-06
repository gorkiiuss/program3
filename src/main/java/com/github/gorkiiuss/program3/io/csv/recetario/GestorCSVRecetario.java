package com.github.gorkiiuss.program3.io.csv.recetario;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class GestorCSVRecetario {
    private static final String DIRECTORIO_DEL_FICHERO = "/io/csv/recetario.csv";
    private static final URL DIRECTORIO_URL = GestorCSVRecetario.class.getResource(DIRECTORIO_DEL_FICHERO);

    public static Receta[] cargarArchivo() throws URISyntaxException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(DIRECTORIO_URL.toURI())));

        ArrayList<Receta> recetas = new ArrayList<>();
        String linea = reader.readLine();
        do {
            String[] valoresEnLinea = linea.split(",");
            int id = Integer.parseInt(valoresEnLinea[0]);
            String nombre = valoresEnLinea[1];
            int comensales = Integer.parseInt(valoresEnLinea[2]);
            int duracionEnMinutos = Integer.parseInt(valoresEnLinea[3]);
            String[] ingredientesEnString = new String[valoresEnLinea.length - 4 - 1];
            for (int i = 4; i < valoresEnLinea.length; i++) {
                ingredientesEnString[i - 4] = valoresEnLinea[i];
            }

            Ingrediente[] ingredientes = new Ingrediente[ingredientesEnString.length];
            for (int i = 0; i < ingredientesEnString.length; i++) {
                String ingredienteEnString = ingredientesEnString[i];

                String[] valoresParaIngrediente = ingredienteEnString.split(":");

                ingredientes[i] = new Ingrediente(valoresParaIngrediente[0], Double.parseDouble(valoresParaIngrediente[1]), valoresParaIngrediente[2]);
            }

            recetas.add(new Receta(id, nombre, comensales, duracionEnMinutos, ingredientes));

            linea = reader.readLine();
        } while(linea != null);

        // TODO: Escribir metodo para que cargue las recetas que hay en el archivo que esta en `DIRECTORIO_DEL_FICHERO`
        return recetas.toArray(new Receta[0]);
    }

    public static void guardarArchivo(Receta[] recetas) throws URISyntaxException, IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(DIRECTORIO_URL.toURI())));

        for (Receta receta : recetas) {
            writer.write(receta.toCSV() + "\n");
            writer.flush();
        }

        writer.close();

        // TODO: Escribir metodo para que guarde `recetas` en el archivo que esta en `DIRECTORIO_DEL_FICHERO`
    }
}
