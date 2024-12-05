package com.github.gorkiiuss.program3.hilos.pausar;

public class UsingSleepWorkingThread extends Thread {

    private volatile boolean isPaused = false;

    @Override
    public void run() {
        System.out.println("Hilo con sleep iniciado.");

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

            if (isPaused) {
                try {
                    Thread.sleep(Long.MAX_VALUE); // Duerme indefinidamente
                } catch (InterruptedException e) {
                    // Hilo con sleep interrumpido para reanudar
                    System.out.println("Hilo con sleep interrumpido para reanudar.");
                }
            }

            // Simulación de operación costosa
            if (i % 100000000 == 0) {
                System.out.println("Contador: " + i);
            }
        }

        System.out.println("Hilo con sleep finalizado.");
    }

    public void pauseThread() {
        isPaused = true;
        System.out.println("Hilo con sleep pausado.");
    }

    public void resumeThread() {
        isPaused = false;
        interrupt(); // Interrumpe el hilo con sleep para despertarlo
        System.out.println("Hilo con sleep reanudado.");
    }
}
