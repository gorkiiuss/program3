package com.github.gorkiiuss.program3.io.csv.pacientes;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Carga del archivo
        Paciente[] pacientes = IOFicherosCSV.cargarArchivo();
        if (pacientes == null)
            return;

        // Procesamiento del archivo
        Medico medico = new Medico();
        System.out.println("\n--- PACIENTES CARGADOS ---\n");
        Arrays.stream(pacientes)
                .forEach(System.out::println);

        System.out.println("\n--- PACIENTES PARA GUARDAR ---\n");
        Arrays.stream(pacientes).forEach(paciente -> {
            medico.diagnosticarPaciente(paciente);
            System.out.println(paciente);
        });

        // Guardado del archivo
        IOFicherosCSV.guardarArchivo(pacientes);
    }
}
