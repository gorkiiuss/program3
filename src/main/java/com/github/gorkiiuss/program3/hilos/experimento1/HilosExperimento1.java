package com.github.gorkiiuss.program3.hilos.experimento1;

public class HilosExperimento1 {
    public static void main(String[] args) {
        System.out.println("\n--- Version Secuencial ---\n");
        long empezarSecuencial = System.currentTimeMillis();

        // Ejecutar de manera secuencial
        HilosExperimento1.tareaExponencial();
        HilosExperimento1.tareaLineal(empezarSecuencial);

        System.out.println("\n--- Version con Hilos ---\n");
        long empezarConHilos = System.currentTimeMillis();

        // Crear los hilos para cada tarea
        Thread hiloLineal = new Thread(() -> HilosExperimento1.tareaLineal(empezarConHilos));
        Thread hiloExponencial = new Thread(HilosExperimento1::tareaExponencial);

        // Iniciar los hilos
        hiloExponencial.start();
        hiloLineal.start();
    }

    public static void tareaLineal(long empieza) {
        System.out.println("Comenzando tarea lineal...");
        for (int i = 0; i < 10; i++) {
            System.out.println("Tarea lineal: " + i);
            try {
                Thread.sleep(500); // Simular un trabajo que lleva tiempo
            } catch (InterruptedException ignore) {

            }
        }

        System.out.println("Tarea lineal completada. Tiempo de ejecución: "
                + (System.currentTimeMillis() - empieza) / 1000. + " segundos.");
    }

    public static void tareaExponencial() {
        System.out.println("Comenzando tarea exponencial...");
        long result = 1;
        for (int i = 0; i < 20; i++) {
            result *= 2;
            System.out.println("Tarea exponencial: 2^" + i + " = " + result);
            try {
                Thread.sleep(1000); // Simular un trabajo que lleva más tiempo
            } catch (InterruptedException ignore) {

            }
        }
        System.out.println("Tarea exponencial completada.");
    }
}
