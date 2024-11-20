package com.github.gorkiiuss.program3.parcial2024.io;

import com.github.gorkiiuss.program3.parcial2024.modelo.ListaDeOrganismos;
import com.github.gorkiiuss.program3.parcial2024.modelo.Organismo;

import javax.swing.*;
import java.io.*;
import java.util.Locale;

public class GestorCSVDeOrganismos {
    private static GestorCSVDeOrganismos instance;

    private GestorCSVDeOrganismos() throws FileNotFoundException {
    }

    public static synchronized GestorCSVDeOrganismos get() {
        if (instance != null) return instance;
        GestorCSVDeOrganismos gestorCSVDeOrganismos = null;
        try {
            gestorCSVDeOrganismos = new GestorCSVDeOrganismos();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "El fichero CSV de organismos no se ha encontrado! " + e.getMessage(),
                    "Error Fatal",
                    JOptionPane.ERROR_MESSAGE
            );
        }
        return gestorCSVDeOrganismos;
    }

    public Organismo[] readAllFromFile(File csvFile) {
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader(csvFile));
        } catch (FileNotFoundException e) { return null; }

        return reader.lines()
                .map(linea -> linea.split(","))
                .map(Organismo::fromValoresEnLinea)
                .toArray(Organismo[]::new);
    }

    public void save(ListaDeOrganismos organismos, File archivo) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(archivo));
            for (Organismo organismo : organismos.getLista()) {
                writer.write(organismo.getClass().getSimpleName().toLowerCase(Locale.ROOT) + "," + organismo.getID() + "," + organismo.getNombre() + "\n");
                writer.flush();
            }

        } catch (IOException ignored) {

        }
    }
}
