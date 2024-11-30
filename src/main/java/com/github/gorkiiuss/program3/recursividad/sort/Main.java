package com.github.gorkiiuss.program3.recursividad.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        // Crear una lista aleatoria muy larga.
        Random random = new Random();

        int size = 50000;
        int[] listForBubbleSort = new int[size];
        int[] listForQuicksort = new int[size];
        int[] listForMergesort = new int[size];
        int[] listForBuiltinSort = new int[size];

        for (int i = 0; i < size; i++) {
            int randomNumber = random.nextInt(0, 500_000);
            listForBubbleSort[i] = randomNumber;
            listForQuicksort[i] = randomNumber;
            listForMergesort[i] = randomNumber;
            listForBuiltinSort[i] = randomNumber;
        }

        // Bubble sort
        BubbleSorter bubbleSorter = new BubbleSorter();

        long initTimeBubbleSort = System.nanoTime();
        bubbleSorter.bubbleSort(listForBubbleSort);
        long endTimeBubbleSort = System.nanoTime();

        double timeBubbleSort = (endTimeBubbleSort - initTimeBubbleSort) / 1_000_000.;
        System.out.println("Tiempo de Bubble Sort: " + timeBubbleSort + " ms");

        // Quicksort
        QuickSorter quickSorter = new QuickSorter();

        long initTimeQuicksort = System.nanoTime();
        quickSorter.quicksort(listForQuicksort);
        long endTimeQuicksort = System.nanoTime();

        double timeQuicksort = (endTimeQuicksort - initTimeQuicksort) / 1_000_000.;
        System.out.println("Tiempo de Quicksort: " + timeQuicksort + " ms");

        // Mergesort
        MergeSorter mergeSorter = new MergeSorter();

        long initTimeMergesort = System.nanoTime();
        mergeSorter.mergesort(listForMergesort);
        long endTimeMergesort = System.nanoTime();

        double timeMergesort = (endTimeMergesort - initTimeQuicksort) / 1_000_000.;
        System.out.println("Tiempo de Mergesort: " + timeMergesort + " ms");

        // Built-in sort
        IntStream builtinListStream = Arrays.stream(listForBuiltinSort);

        long initTimeBuiltinSorter = System.nanoTime();
        IntStream sortedBuiltinListStream = builtinListStream.sorted();
        long endTimeBuiltinSorter = System.nanoTime();

        int[] builtinSortedList = sortedBuiltinListStream.toArray();

        double timeBuiltinSorter = (endTimeBuiltinSorter - initTimeBuiltinSorter) / 1_000_000.;
        System.out.println("Tiempo de la ordenación de java: " + timeBuiltinSorter + " ms");

        // Verificar si ambos arrays están ordenados correctamente y son iguales
        boolean areTheListsEqual = Arrays.equals(builtinSortedList, listForBubbleSort) &&
                Arrays.equals(builtinSortedList, listForQuicksort) &&
                Arrays.equals(builtinSortedList, listForMergesort);
        System.out.println("¿Los arrays ordenados son iguales? " + areTheListsEqual);
    }
}
