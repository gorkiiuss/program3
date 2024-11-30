package com.github.gorkiiuss.program3.recursividad.sort;

public class BubbleSorter {
    public void bubbleSort(int[] list) {
        for (int j = 0; j < list.length - 1; j++) {
            for (int i = 0; i < list.length - 1 - j; i++) {
                int currentValue = list[i];
                int nextValue = list[i + 1];

                if (currentValue > nextValue) {
                    list[i] = nextValue;
                    list[i + 1] = currentValue;
                }
            }
        }
    }
}
