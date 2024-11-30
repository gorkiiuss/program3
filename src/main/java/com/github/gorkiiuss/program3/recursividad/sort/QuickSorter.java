package com.github.gorkiiuss.program3.recursividad.sort;

public class QuickSorter {
    public void quicksort(int[] list) {
        quicksort(list, 0, list.length - 1);
    }

    private void quicksort(int[] list, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return;

        int pivot = partition(list, startIdx, endIdx);
        quicksort(list, startIdx, pivot - 1);
        quicksort(list, pivot + 1, endIdx);
    }

    private int partition(int[] list, int startIdx, int endIdx) {
        int pivotIdx = endIdx;
        int pivotValue = list[pivotIdx];

        int endIdxForValuesLessThanPivot = startIdx - 1;
        int currentValue;
        for (int currentIdx = startIdx; currentIdx < endIdx; currentIdx++) {
            currentValue = list[currentIdx];
            if (currentValue < pivotValue) {
                // Si encontramos un valor menor que el pivote, colocarlo a la izquierda del mismo, sin seguir un orden
                // especifico, pero en una sublista desordenada desde `startIdx`.
                endIdxForValuesLessThanPivot++;
                list[currentIdx] = list[endIdxForValuesLessThanPivot];
                list[endIdxForValuesLessThanPivot] = currentValue;
            }
        }

        // Intercambiar el valor de al lado del ultimo valor de la sublista de los menores por el pivote, para que asi
        // este quede en el centro. Ademas, actualizar el indice del pivote.
        list[pivotIdx] = list[endIdxForValuesLessThanPivot + 1];
        list[endIdxForValuesLessThanPivot + 1] = pivotValue;
        pivotIdx = endIdxForValuesLessThanPivot + 1;

        return pivotIdx;
    }
}
