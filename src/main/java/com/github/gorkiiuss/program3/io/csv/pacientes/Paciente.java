package com.github.gorkiiuss.program3.io.csv.pacientes;

import java.util.Arrays;

public class Paciente {
    private final int id;
    private final String nombre;
    private final int edad;
    private final Sintoma[] sintomas;

    private Diagnostico diagnostico;

    public Paciente(int id, String nombre, int edad, Diagnostico diagnostico, Sintoma[] sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.diagnostico = diagnostico;
        this.sintomas = sintomas;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Sintoma[] getSintomas() {
        return this.sintomas;
    }

    @Override
    public String toString() {
        String str = "El paciente nº " + id + " de nombre \"" + nombre + "\" y con edad de " + edad + " año(s), ";
        if (diagnostico == null)
            str += "tiene los siguientes sintomas: " + Arrays.toString(sintomas);
        else str += "tiene el siguiente diagnostico: " + diagnostico;

        return str;
    }

    public String toCSV() {
        StringBuilder sintomasCSV = new StringBuilder();
        for (Sintoma sintoma : sintomas) {
            sintomasCSV.append(sintoma).append(",");
        }
        sintomasCSV.deleteCharAt(sintomasCSV.length() - 1);

        return id + "," + nombre + "," + edad + "," + diagnostico + "," + sintomasCSV;
    }
}
