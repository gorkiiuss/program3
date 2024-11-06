package com.github.gorkiiuss.program3.io.csv.pacientes;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

public class IOFicherosCSV {

    public static final String DIRECTORIO_ARCHIVO_PACIENTES = "/io/csv/pacientes.csv";
    public static final URL URL_ARCHIVO_PACIENTES = IOFicherosCSV.class.getResource(DIRECTORIO_ARCHIVO_PACIENTES);

    public static Paciente[] cargarArchivo() {
        if (URL_ARCHIVO_PACIENTES == null)
            return null;

        Paciente[] pacientes = null;
        try {
            URI pacientesArchivoURI = URL_ARCHIVO_PACIENTES.toURI();
            File pacientesArchivo = new File(pacientesArchivoURI);

            System.out.println("Procesando archivo " + pacientesArchivoURI);

            BufferedReader reader = new BufferedReader(new FileReader(pacientesArchivo));

            pacientes = reader.lines()
                    .map(line -> line.split(","))
                    .map(valoresEnLinea -> {
//                        for (int i = 0; i < valoresEnLinea.length; i++) {
//                            System.out.println(valoresEnLinea[i]);
//                        }
                        int id = Integer.parseInt(valoresEnLinea[0]);
                        String nombre = valoresEnLinea[1];
                        int edad = Integer.parseInt(valoresEnLinea[2]);
                        Diagnostico diagnostico = Diagnostico.parseDiagnostico(valoresEnLinea[3]);
                        Sintoma[] sintomas = Arrays.stream(valoresEnLinea, 4, valoresEnLinea.length)
                                .map(Sintoma::parseSintoma)
                                .toArray(Sintoma[]::new);
                        return new Paciente(id, nombre, edad, diagnostico, sintomas);
                    })
                    .toArray(Paciente[]::new);

            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return pacientes;
    }

    public static void guardarArchivo(Paciente[] pacientes) {
        if (URL_ARCHIVO_PACIENTES == null)
            return;

        try {
            URI pacientesArchivoURI = URL_ARCHIVO_PACIENTES.toURI();
            File pacientesArchivo = new File(pacientesArchivoURI);

            BufferedWriter writer = new BufferedWriter(new FileWriter(pacientesArchivo));

            for (Paciente paciente : pacientes) {
                writer.write(paciente.toCSV() + "\n");
                writer.flush();
            }

            writer.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
