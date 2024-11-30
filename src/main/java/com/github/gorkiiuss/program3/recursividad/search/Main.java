package com.github.gorkiiuss.program3.recursividad.search;

import com.github.gorkiiuss.program3.recursividad.sort.QuickSorter;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        IterativeSearcher iterativeSearcher = new IterativeSearcher();
        BinarySearcher binarySearcher = new BinarySearcher();

        int size = 50000;
        int[] listForIterativeSearch = new int[size];
        int[] listForBinarySearch = new int[size];

        int numberInListIdx = random.nextInt(size);
        int numberInList = -1;
        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(0, 500_000);
            if (i == numberInListIdx) numberInList = randomNumber;
            listForIterativeSearch[i] = randomNumber;
            listForBinarySearch[i] = randomNumber;
        }

        if (numberInList == -1) numberInList = listForIterativeSearch[0];

        new QuickSorter().quicksort(listForBinarySearch);

        int numberNotInList;
        do {
            numberNotInList = random.nextInt(0, 500_000);
        } while (new BinarySearcher().search(listForBinarySearch, numberNotInList));

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        // Iterative search - finds
        long startTimeIterativeFinds = System.nanoTime();
        boolean resultIterativeFinds = iterativeSearcher.search(listForIterativeSearch, numberInList);
        long endTimeIterativeFinds = System.nanoTime();

        double timeIterativeFinds = (endTimeIterativeFinds - startTimeIterativeFinds) / 1_000_000.;
        System.out.println("Resultado de `Busqueda iterativa encuentra` es: \"" +
                (resultIterativeFinds ? "correcta" : "incorrecta") + "\""
        );
        System.out.println("`Busqueda iterativa encuentra` ha durado: " + timeIterativeFinds);

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        // Iterative search - does not find
        long startTimeIterativeDoesNotFind = System.nanoTime();
        boolean resultIterativeDoesNotFind = iterativeSearcher.search(listForIterativeSearch, numberNotInList);
        long endTimeIterativeDoesNotFind = System.nanoTime();

        double timeIterativeDoesNotFind = (endTimeIterativeDoesNotFind - startTimeIterativeDoesNotFind) / 1_000_000.;
        System.out.println("Resultado de `Busqueda iterativa no encuentra` es: \"" +
                (!resultIterativeDoesNotFind ? "correcta" : "incorrecta") + "\""
        );
        System.out.println("`Busqueda iterativa no encuentra` ha durado: " + timeIterativeDoesNotFind);

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        // Binary search - finds
        long startTimeBinaryFinds = System.nanoTime();
        boolean resultBinaryFinds = binarySearcher.search(listForBinarySearch, numberInList);
        long endTimeBinaryFinds = System.nanoTime();

        double timeBinaryFinds = (endTimeBinaryFinds - startTimeBinaryFinds) / 1_000_000.;
        System.out.println("Resultado de `Busqueda binaria encuentra` es: \"" +
                (resultBinaryFinds ? "correcta" : "incorrecta") + "\""
        );
        System.out.println("`Busqueda binaria encuentra` ha durado: " + timeBinaryFinds);

        System.out.println("\n-------------------------------------------------------------------------------------\n");

        // Binary search - does not find
        long startTimeBinaryDoesNotFind = System.nanoTime();
        boolean resultBinaryDoesNotFind = binarySearcher.search(listForBinarySearch, numberNotInList);
        long endTimeBinaryDoesNotFind = System.nanoTime();

        double timeBinaryDoesNotFind = (endTimeBinaryDoesNotFind - startTimeBinaryDoesNotFind) / 1_000_000.;
        System.out.println("Resultado de `Busqueda binaria no encuentra` es: \"" +
                (!resultBinaryDoesNotFind ? "correcta" : "incorrecta") + "\""
        );
        System.out.println("`Busqueda binaria no encuentra` ha durado: " + timeBinaryDoesNotFind);



        System.out.println("\n-------------------------------------------------------------------------------------");
    }
}
