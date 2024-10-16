package com.github.gorkiiuss.program3.hilos.experimento2;

public class HilosExperimento2 {
    public static void main(String[] args) {
        // Crear el primer hilo
        Thread hilo1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo A - Mensaje " + i);
                try {
                    Thread.sleep(100); // Simular un pequeño retraso
                } catch (InterruptedException ignore) {

                }
            }
        });

        // Crear el segundo hilo
        Thread hilo2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Hilo B - Mensaje " + i);
                try {
                    Thread.sleep(100); // Simular un pequeño retraso
                } catch (InterruptedException ignore) {

                }
            }
        });

        // Iniciar ambos hilos
        hilo1.start();
        hilo2.start();
    }
}
