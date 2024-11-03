package com.github.gorkiiuss.program3.io.lang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;

public class GestorDeIdiomas {
    private static final String DIRECTORIO_DE_MENSAJES = "/io/lang/";
    private static final String NOMBRE_ARCHIVO_ESPANOL = "es_ES";
    private static final String NOMBRE_ARCHIVO_EUSKERA = "eus_EUS";
    private static final String NOMBRE_ARCHIVO_INGLES = "us_EN";
    private static final String NOMBRE_ARCHIVO_ALEMAN = "de_DE";
    private static final String EXTENSION = ".lang";

    public static Mensaje[] cargarMensajes(String idiomaElegido) {
        System.out.println("Cargando mensajes en " + idiomaElegido);
        URL url = switch (idiomaElegido) {
            case "es_ES" -> GestorDeIdiomas.class.getResource(DIRECTORIO_DE_MENSAJES + NOMBRE_ARCHIVO_ESPANOL + EXTENSION);
            case "eus_EUS" -> GestorDeIdiomas.class.getResource(DIRECTORIO_DE_MENSAJES + NOMBRE_ARCHIVO_EUSKERA + EXTENSION);
            case "us_EN" -> GestorDeIdiomas.class.getResource(DIRECTORIO_DE_MENSAJES + NOMBRE_ARCHIVO_INGLES + EXTENSION);
            case "de_DE" -> GestorDeIdiomas.class.getResource(DIRECTORIO_DE_MENSAJES + NOMBRE_ARCHIVO_ALEMAN + EXTENSION);
            default -> null;
        };
        if (url == null)
            return null;

        File archivo;
        try { archivo = new File(url.toURI()); } catch (URISyntaxException e) { return null; }

        BufferedReader lector;
        try { lector = new BufferedReader(new FileReader(archivo)); } catch (FileNotFoundException e) { return null; }

        return lector.lines()
                .map(linea -> linea.split(": "))
                .map(valoresEnLinea -> new Mensaje(valoresEnLinea[0], valoresEnLinea[1]))
                .toArray(Mensaje[]::new);
    }
}
