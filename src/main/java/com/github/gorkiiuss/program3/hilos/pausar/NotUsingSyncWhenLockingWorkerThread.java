package com.github.gorkiiuss.program3.hilos.pausar;

public class NotUsingSyncWhenLockingWorkerThread extends Thread {
    private volatile boolean isPaused = false;
    private final Object pauseLock = new Object();

    @Override
    public void run() {
        System.out.println("Hilo sin sincronización iniciado.");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            // No se sincroniza antes de llamar a wait()
            if (isPaused) {
                try {
                    pauseLock.wait(); // Esto causará IllegalMonitorStateException
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Hilo sin sincronización interrumpido.");
                }
            }

            // Simulación de operación costosa
            if (i % 100000000 == 0) {
                System.out.println("Contador: " + i);
            }
        }

        System.out.println("Hilo sin sincronización finalizado.");
    }

    public void pauseThread() {
        isPaused = true;
        System.out.println("Hilo sin sincronización pausado.");
    }

    public void resumeThread() {
        // No se sincroniza antes de llamar a notifyAll()
        isPaused = false;
        pauseLock.notifyAll(); // Esto causará IllegalMonitorStateException
        System.out.println("Hilo sin sincronización reanudado.");
    }
}
