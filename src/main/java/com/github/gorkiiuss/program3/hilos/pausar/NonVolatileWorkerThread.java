package com.github.gorkiiuss.program3.hilos.pausar;

public class NonVolatileWorkerThread extends Thread {

    // No se utiliza 'volatile' en isPaused
    private boolean isPaused = false;
    private final Object pauseLock = new Object();

    @Override
    public void run() {
        System.out.println("Hilo sin volatile iniciado.");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            synchronized (pauseLock) {
                while (isPaused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Hilo sin volatile interrumpido.");
                    }
                }
            }

            // Simulación de operación costosa
            if (i % 100000000 == 0) {
                System.out.println("Contador: " + i);
            }
        }

        System.out.println("Hilo sin volatile finalizado.");
    }

    public void pauseThread() {
        isPaused = true; // Sin 'volatile', puede no ser visible para el Hilo sin volatile
        System.out.println("Hilo sin volatile pausado.");
    }

    public void resumeThread() {
        synchronized (pauseLock) {
            isPaused = false;
            pauseLock.notifyAll();
            System.out.println("Hilo sin volatile reanudado.");
        }
    }
}
