package com.github.gorkiiuss.program3.swing.editors.tablapersonas;

public class Persona {
    private int id;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private int edad;
    private boolean gafas;

    // Constructor por defecto
    public Persona() {
    }

    // Constructor con parámetros
    public Persona(int id, String nombre, String apellido1, String apellido2, int edad, boolean gafas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.edad = edad;
        this.gafas = gafas;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isGafas() {
        return gafas;
    }

    public void setGafas(boolean gafas) {
        this.gafas = gafas;
        System.out.println("`gafas` para la persona nº" + id + " se ha actualizado. Ahora es: " + gafas);
    }
}
