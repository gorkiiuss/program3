package com.github.gorkiiuss.program3.recursividad.search;

public class BinarySearcher {
    public boolean search(int[] l, int n) {
        return search(l, n, 0, l.length - 1);
    }

    private boolean search(int[] l, int n, int initIdx, int endIdx) {
        if (initIdx > endIdx)
            return false;

        int midIdx = (endIdx - initIdx) / 2 + initIdx;

        if (l[midIdx] == n) return true;
        else if (l[midIdx] > n) return search(l, n, initIdx, midIdx - 1);
        else return search(l, n, midIdx + 1, endIdx);
    }
}
