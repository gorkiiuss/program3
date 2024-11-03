package com.github.gorkiiuss.program3.io.csv.recetario;

public class Ingrediente {
    private static final Ingrediente INVALIDO = new Ingrediente(null, -1, null);

    private final String nombre;
    private final double cantidadEnUnidades;
    private final String unidadDeMedicion;

    public Ingrediente(String nombre, double cantidadEnUnidades, String unidadDeMedicion) {
        this.nombre = nombre;
        this.cantidadEnUnidades = cantidadEnUnidades;
        this.unidadDeMedicion = unidadDeMedicion;
    }

    public static Ingrediente parseIngrediente(String s) {
        if (s == null) return Ingrediente.INVALIDO;
        String[] valoresEnS = s.split(":");
        if (valoresEnS.length != 3) return Ingrediente.INVALIDO;

        String nombre = valoresEnS[0];
        // TODO: Crear ingrediente
        //  1. Sacar cantidad. Si es "Al gusto" entonces ponerlo a -1.
        //  2. Sacar unidad de medicion.
        //  3. Hacer el return con el nuevo Ingrediente.

        return null;
    }

    @Override
    public String toString() {
        return (cantidadEnUnidades == -1.0 ? "Al gusto" : cantidadEnUnidades) +
                (cantidadEnUnidades == -1.0 ? "" : " " + unidadDeMedicion) + " de "
                + nombre;
    }

    public String toCSV() {
        return nombre + ":" + cantidadEnUnidades + ":" + unidadDeMedicion;
    }
}
