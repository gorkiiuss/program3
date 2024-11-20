package com.github.gorkiiuss.program3.parcial2024.modelo;

public abstract class Organismo {
    private static final Organismo ORGANISMO_INVALIDO_MALA_ESTRUCTURA =
            new Organismo(-1, "Las líneas en el organismo no son correctas.") { };
    private static Organismo organismoInvalidoTipoInvalido(String tipo) {
        return new Organismo(-2, "No existe organismo de tipo \"" + tipo + "\".") { };
    }
    private static final Organismo ORGANISMO_INVALIDO = new Organismo(-3, "Organismo invalido.") { };

    public static boolean isOrganismoInvalidoTipoInvalido(Organismo organismo) {
        return organismo.id == -2;
    }

    private int id;

    private String nombre;

    public Organismo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static Organismo fromValoresEnLinea(String[] valoresEnLinea) {
        if (valoresEnLinea == null || valoresEnLinea.length < 2)
            return ORGANISMO_INVALIDO_MALA_ESTRUCTURA;

        String tipo = valoresEnLinea[0];
        if (!tipo.equals("planta") && !tipo.equals("carnivoro") && !tipo.equals("herviboro"))
            return organismoInvalidoTipoInvalido(tipo);

        int id = Integer.parseInt(valoresEnLinea[1]);
        String nombre = valoresEnLinea[2];

        switch (tipo) {
            case "planta":
                return new Planta(id, nombre);
            case "carnivoro":
                return new Carnivoro(id, nombre);
            case "herviboro":
                return new Herviboro(id, nombre);
            default:
                return null;
        }
    }

    public int getID() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Organismo from(int id) {
        Class<? extends Organismo> clazz = this.getClass();
        if (clazz.equals(Planta.class)) return new Planta(id, this.nombre);
        else if (clazz.equals(Herviboro.class)) return new Herviboro(id, this.nombre);
        else if (clazz.equals(Carnivoro.class)) return new Carnivoro(id, this.nombre);
        else return null;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Organismo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
