package com.github.gorkiiuss.program3.ejercicios.preparacionparcial.ventanadeslizante.gorkapuente;

public enum Direction {
    UP("↑"), DOWN("↓"), RIGHT("→"), LEFT("←");

    private final String text;

    Direction(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
