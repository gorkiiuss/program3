package com.github.gorkiiuss.program3.swing.jtable.hotel;

public class Hotel {
    public static void main(String[] args) {
        Object[][] inquilinos = {
                {"Juan", "Pérez", 30, "Perro", 101, false},
                {"María", "Gómez", 28, "Gato", 102, true},
                {"Carlos", "Ramírez", 45, "Dragón", 103, false},
                {"Ana", "López", 33, "Pingüino", 104, false},
                {"Pedro", "Sánchez", 40, "Unicornio", 105, true},
                {"Lucía", "Martínez", 25, "Koala", 106, false},
                {"Raúl", "Fernández", 50, "Tortuga", 107, false},
                {"Sofía", "Díaz", 35, "Gato", 108, true},
        };

        String[] nombresDeColumna =
                {"Nombre", "Apellidos", "Edad", "Mascota", "Número de la habitación", "¿Es pelirrojo?"};
    }
}
