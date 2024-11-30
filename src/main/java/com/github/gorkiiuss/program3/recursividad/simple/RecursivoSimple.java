package com.github.gorkiiuss.program3.recursividad.simple;

import java.math.BigInteger;
import java.util.Arrays;

public class RecursivoSimple {
    public static final BigInteger ERROR = BigInteger.valueOf(-1);

    public BigInteger factorial(int n) {
        if (n < 0) return ERROR;
        return factorialRecursivo(n);
    }

    /**
     * Definicion recursiva matematica del factorial:
     *  - Caso base: 0! = 1
     *  - Definicion: n! = n * (n - 1)!
     */
    private BigInteger factorialRecursivo(int n) {
        // Caso base
        if (n == 0)
            return BigInteger.ONE;

        // Caso general
        return BigInteger.valueOf(n).multiply(factorialRecursivo(n - 1));
    }

    public BigInteger fibonacci(int n) {
        if (n < 0) return ERROR;
        return fibonacciRecursivo(n);
    }

    /**
     * Definicion recursiva matematica de la secuencia de Fibonacci:
     *  - Caso base 1: Fib(0) = 0
     *  - Caso base 2: Fib(1) = 1
     *  - Definicion: Fib(n) = Fib(n - 1) + Fib(n - 2)
     */
    private BigInteger fibonacciRecursivo(int n) {
        if (n == 0 || n == 1)
            return BigInteger.valueOf(n);
        return fibonacciRecursivo(n - 1).add(fibonacciRecursivo(n - 2));
    }

    private BigInteger[] tablaFibonacci;
    public BigInteger fibonacciDinamico(int n) {
        if (n < 0) return ERROR;
        tablaFibonacci = new BigInteger[n + 1];
        Arrays.fill(tablaFibonacci, BigInteger.valueOf(-1));
        return fibonacciDinamicoRecursivo(n);
    }

    private BigInteger fibonacciDinamicoRecursivo(int n) {
        if (!tablaFibonacci[n].equals(BigInteger.valueOf(-1)))
            return tablaFibonacci[n];

        BigInteger fibonacciN;
        if (n == 0 || n == 1) fibonacciN = BigInteger.valueOf(n);
        else fibonacciN = fibonacciDinamicoRecursivo(n - 1).add(fibonacciDinamicoRecursivo(n - 2));

        tablaFibonacci[n] = fibonacciN;
        return fibonacciN;
    }
}
