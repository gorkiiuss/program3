package com.github.gorkiiuss.program3.recursividad.laberintografo;

public class SolucionadorDeLaberintos {
    public static void main(String[] args) {
        char[][] laberintoEnMatrizDeChars = {
                { 'E', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ' },
                { ' ', '#', ' ', '#', ' ', '#', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ' },
                { ' ', ' ', ' ', '#', ' ', '#', '#', '#', ' ', '#', ' ', '#', ' ', ' ', ' ' },
                { ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', ' ', ' ', ' ' },
                { ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' ', ' ', ' ' },
                { ' ', ' ', ' ', '#', '#', '#', ' ', '#', ' ', ' ', ' ', '#', '#', '#', '#' },
                { ' ', ' ', ' ', ' ', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', 'S' }
        };

        Laberinto laberinto = Laberinto.Builder.procesarLaberintoEnMatrizDeChars(laberintoEnMatrizDeChars).build();
        System.out.println("El laberinto" + (laberinto.solucionar() ? " " : " no ") + "se ha solucionado.");
    }
}
