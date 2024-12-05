package com.github.gorkiiuss.program3.hilos.pausar;

class WorkerThread extends Thread {

    private volatile boolean isPaused = false;
    private final Object pauseLock = new Object();

    @Override
    public void run() {
        System.out.println("Hilo iniciado.");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            synchronized (pauseLock) {
                while (isPaused) {
                    try {
                        pauseLock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Hilo interrumpido.");
                    }
                }
            }

            // Simulación de operación costosa
            if (i % 100000000 == 0) {
                System.out.println("Contador: " + i);
            }
        }

        System.out.println("Hilo finalizado.");
    }

    public void pauseThread() {
        isPaused = true;
        System.out.println("Hilo pausado.");
    }

    public void resumeThread() {
        synchronized (pauseLock) {
            isPaused = false;
            pauseLock.notifyAll();
            System.out.println("Hilo reanudado.");
        }
    }
}
