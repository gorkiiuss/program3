package com.github.gorkiiuss.program3.recursividad.sort;

public class MergeSorter {
    public void mergesort(int[] list) {
        if (list.length > 1) {
            int middle = list.length / 2;

            // Dividir el array en dos mitades
            int[] left = new int[middle];
            int[] right = new int[list.length - middle];
            System.arraycopy(list, 0, left, 0, middle);
            System.arraycopy(list, middle, right, 0, list.length - middle);

            // Ordenar recursivamente cada mitad
            mergesort(left);
            mergesort(right);

            // Combinar las mitades ordenadas
            merge(list, left, right);
        }
    }

    private void merge(int[] list, int[] left, int[] right) {
        int idxLeft = 0;
        int idxRight = 0;
        int idx = 0;

        // Combinar los arrays hasta que uno se termine
        while (idxLeft < left.length && idxRight < right.length) {
            if (left[idxLeft] <= right[idxRight]) {
                list[idx] = left[idxLeft];
                idxLeft++;
            } else {
                list[idx] = right[idxRight];
                idxRight++;
            }
            idx++;
        }

        // Copiar los elementos restantes de izquierda (si los hay)
        while (idxLeft < left.length) {
            list[idx] = left[idxLeft];
            idxLeft++;
            idx++;
        }

        // Copiar los elementos restantes de derecha (si los hay)
        while (idxRight < right.length) {
            list[idx] = right[idxRight];
            idxRight++;
            idx++;
        }
    }
}
