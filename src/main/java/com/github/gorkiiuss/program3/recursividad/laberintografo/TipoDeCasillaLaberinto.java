package com.github.gorkiiuss.program3.recursividad.laberintografo;

public enum TipoDeCasillaLaberinto {
    ENTRADA('E'), SALIDA('S'), PASILLO(' '), MURO('#');

    private final char imagenCasilla;

    TipoDeCasillaLaberinto(char imagenCasilla) {
        this.imagenCasilla = imagenCasilla;
    }

    public char getImagenCasilla() {
        return imagenCasilla;
    }
}
