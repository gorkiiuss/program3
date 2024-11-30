package com.github.gorkiiuss.program3.recursividad.search;

public class IterativeSearcher {
    public boolean search(int[] l, int n) {
        for (int i : l) {
            if (i == n) return true;
        }
        return false;
    }
}
