package com.github.gorkiiuss.program3.hilos.experimento3;

public class HilosExperimento3 {
    private int contador = 0;

    public void incrementar() {
        contador++;
    }

    public synchronized void incrementarSincronizado() {
        contador++;
    }

    public static void main(String[] args) {
        HilosExperimento3 demo = new HilosExperimento3();

        // Sin sincronización
        Runnable tarea = () -> {
            for (int i = 0; i < 1000; i++) {
                demo.incrementar();
            }
        };

        Thread hilo1 = new Thread(tarea);
        Thread hilo2 = new Thread(tarea);
        hilo1.start();
        hilo2.start();

        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException ignore) {

        }

        System.out.println("Valor final sin sincronización: " + demo.contador);

        // Con sincronización
        demo.contador = 0;
        Runnable tareaSincronizada = () -> {
            for (int i = 0; i < 1000; i++) {
                demo.incrementarSincronizado();
            }
        };

        Thread hilo3 = new Thread(tareaSincronizada);
        Thread hilo4 = new Thread(tareaSincronizada);
        hilo3.start();
        hilo4.start();

        try {
            hilo3.join();
            hilo4.join();
        } catch (InterruptedException ignore) {

        }

        System.out.println("Valor final con sincronización: " + demo.contador);
    }
}