package com.github.gorkiiuss.program3.recursividad.simple;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        IterativoSimple iterativoSimple = new IterativoSimple();
        RecursivoSimple recursivoSimple = new RecursivoSimple();

        int valorParaFactorial1 = 5;
        int valorParaFactorial2 = 10;
        int valorParaFactorial3 = 20;
        int valorParaFactorial4 = 100;

        int valorParaFibonacci1 = 3;
        int valorParaFibonacci2 = 13;
        int valorParaFibonacci3 = 45;
        int valorParaFibonacci4 = 100;

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        long startTimeFactorialIterativo = System.nanoTime();
        BigInteger resultadoFactorialIterativo1 = iterativoSimple.factorial(valorParaFactorial1);
        BigInteger resultadoFactorialIterativo2 = iterativoSimple.factorial(valorParaFactorial2);
        BigInteger resultadoFactorialIterativo3 = iterativoSimple.factorial(valorParaFactorial3);
        BigInteger resultadoFactorialIterativo4 = iterativoSimple.factorial(valorParaFactorial4);
        long endTimeFactorialIterativo = System.nanoTime();

        double timeFactorialIterativo = (endTimeFactorialIterativo - startTimeFactorialIterativo) / 1_000_000.;
        System.out.println("Resultados de `Factorial iterativo`:\n" +
                "\t- " + valorParaFactorial1 + "! = " + resultadoFactorialIterativo1 + ",\n" +
                "\t- " + valorParaFactorial2 + "! = " + resultadoFactorialIterativo2 + ",\n" +
                "\t- " + valorParaFactorial3 + "! = " + resultadoFactorialIterativo3 + ",\n" +
                "\t- " + valorParaFactorial4 + "! = " + resultadoFactorialIterativo4 + "\n"
        );
        System.out.println("`Factorial iterativo` ha durado: " + timeFactorialIterativo + " ms.");
        System.out.println("\n-------------------------------------------------------------------------------------\n");

        long startTimeFibonacciIterativo = System.nanoTime();
        BigInteger resultadoFibonacciIterativo1 = iterativoSimple.fibonacci(valorParaFibonacci1);
        BigInteger resultadoFibonacciIterativo2 = iterativoSimple.fibonacci(valorParaFibonacci2);
        BigInteger resultadoFibonacciIterativo3 = iterativoSimple.fibonacci(valorParaFibonacci3);
        BigInteger resultadoFibonacciIterativo4 = iterativoSimple.fibonacci(valorParaFibonacci4);
        long endTimeFibonacciIterativo = System.nanoTime();

        double timeFibonacciIterativo = (endTimeFibonacciIterativo - startTimeFibonacciIterativo) / 1_000_000.;
        System.out.println("Resultados de `Fibonacci iterativo`:\n" +
                "\t- Fib(" + valorParaFibonacci1 + ") = " + resultadoFibonacciIterativo1 + ",\n" +
                "\t- Fib(" + valorParaFibonacci2 + ") = " + resultadoFibonacciIterativo2 + ",\n" +
                "\t- Fib(" + valorParaFibonacci3 + ") = " + resultadoFibonacciIterativo3 + ",\n" +
                "\t- Fib(" + valorParaFibonacci4 + ") = " + resultadoFibonacciIterativo4 + "\n"
        );
        System.out.println("`Fibonacci iterativo` ha durado: " + timeFibonacciIterativo + " ms.");

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        long startTimeFactorialRecursivo = System.nanoTime();
        BigInteger resultadoFactorialRecursivo1 = recursivoSimple.factorial(valorParaFactorial1);
        BigInteger resultadoFactorialRecursivo2 = recursivoSimple.factorial(valorParaFactorial2);
        BigInteger resultadoFactorialRecursivo3 = recursivoSimple.factorial(valorParaFactorial3);
        BigInteger resultadoFactorialRecursivo4 = recursivoSimple.factorial(valorParaFactorial4);
        long endTimeFactorialRecursivo = System.nanoTime();

        double timeFactorialRecursivo = (endTimeFactorialRecursivo - startTimeFactorialRecursivo) / 1_000_000.;
        System.out.println("Resultados de `Factorial recursivo`:\n" +
                "\t- " + valorParaFactorial1 + "! = " + resultadoFactorialRecursivo1 + ",\n" +
                "\t- " + valorParaFactorial2 + "! = " + resultadoFactorialRecursivo2 + ",\n" +
                "\t- " + valorParaFactorial3 + "! = " + resultadoFactorialRecursivo3 + ",\n" +
                "\t- " + valorParaFactorial4 + "! = " + resultadoFactorialRecursivo4 + "\n"
        );
        System.out.println("`Factorial recursivo` ha durado: " + timeFactorialRecursivo + " ms.");

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        long startTimeFibonacciRecursivo = System.nanoTime();
        BigInteger resultadoFibonacciRecursivo1 = recursivoSimple.fibonacci(valorParaFibonacci1);
        BigInteger resultadoFibonacciRecursivo2 = recursivoSimple.fibonacci(valorParaFibonacci2);
        BigInteger resultadoFibonacciRecursivo3 = recursivoSimple.fibonacci(valorParaFibonacci3);
        long endTimeFibonacciRecursivo = System.nanoTime();

        double timeFibonacciRecursivo = (endTimeFibonacciRecursivo - startTimeFibonacciRecursivo) / 1_000_000.;
        System.out.println("Resultados de `Fibonacci recursivo`:\n" +
                "\t- Fib(" + valorParaFibonacci1 + ") = " + resultadoFibonacciRecursivo1 + ",\n" +
                "\t- Fib(" + valorParaFibonacci2 + ") = " + resultadoFibonacciRecursivo2 + ",\n" +
                "\t- Fib(" + valorParaFibonacci3 + ") = " + resultadoFibonacciRecursivo3 + "\n"
        );
        System.out.println("`Fibonacci recursivo` ha durado: " + timeFibonacciRecursivo + " ms.");

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        long startTimeFibonacciRecursivoDinamico = System.nanoTime();
        BigInteger resultadoFibonacciRecursivoDinamico1 = recursivoSimple.fibonacciDinamico(valorParaFibonacci1);
        BigInteger resultadoFibonacciRecursivoDinamico2 = recursivoSimple.fibonacciDinamico(valorParaFibonacci2);
        BigInteger resultadoFibonacciRecursivoDinamico3 = recursivoSimple.fibonacciDinamico(valorParaFibonacci3);
        BigInteger resultadoFibonacciRecursivoDinamico4 = recursivoSimple.fibonacciDinamico(valorParaFibonacci4);
        long endTimeFibonacciRecursivoDinamico = System.nanoTime();

        double timeFibonacciRecursivoDinamico =
                (endTimeFibonacciRecursivoDinamico - startTimeFibonacciRecursivoDinamico) / 1_000_000.;
        System.out.println("Resultados de `Fibonacci recursivo dinamico`:\n" +
                "\t- Fib(" + valorParaFibonacci1 + ") = " + resultadoFibonacciRecursivoDinamico1 + ",\n" +
                "\t- Fib(" + valorParaFibonacci2 + ") = " + resultadoFibonacciRecursivoDinamico2 + ",\n" +
                "\t- Fib(" + valorParaFibonacci3 + ") = " + resultadoFibonacciRecursivoDinamico3 + ",\n" +
                "\t- Fib(" + valorParaFibonacci4 + ") = " + resultadoFibonacciRecursivoDinamico4 + "\n"
        );
        System.out.println("`Fibonacci recursivo dinamico` ha durado: " + timeFibonacciRecursivoDinamico + " ms.");

        System.out.println("\n-------------------------------------------------------------------------------------");
    }
}
