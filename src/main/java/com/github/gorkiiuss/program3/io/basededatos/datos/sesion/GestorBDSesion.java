package com.github.gorkiiuss.program3.io.basededatos.datos.sesion;

public class GestorBDSesion {
    private static GestorBDSesion instance;

    private GestorBDSesion() { }

    public static synchronized GestorBDSesion get() {
        if (instance == null) instance = new GestorBDSesion();
        return instance;
    }


}
