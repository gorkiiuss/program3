package com.github.gorkiiuss.program3.recursividad.simple;

import java.math.BigInteger;

public class IterativoSimple {
    public static final BigInteger ERROR = BigInteger.valueOf(-1);

    public BigInteger factorial(int n) {
        if (n < 0) return ERROR; // Error!

        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i < n + 1; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }

    public BigInteger fibonacci(int n) {
        if (n < 0) return ERROR; // Error!

        BigInteger fibActual = BigInteger.ZERO;
        BigInteger fibSiguiente = BigInteger.ONE;
        BigInteger temp;
        for (int i = 0; i < n; i++) {
            temp = fibSiguiente;
            fibSiguiente = fibActual.add(fibSiguiente);
            fibActual = temp;
        }
        return fibActual;
    }
}
