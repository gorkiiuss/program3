package com.github.gorkiiuss.program3.recursividad.laberintografo;

public enum Direccion {
    ARRIBA, DERECHA, ABAJO, IZQUIERDA;


    @Override
    public String toString() {
        return switch (this) {
            case ARRIBA -> "arriba";
            case DERECHA -> "la derecha";
            case ABAJO -> "abajo";
            case IZQUIERDA -> "la izquierda";
        };
    }
}
