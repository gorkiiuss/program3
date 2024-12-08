package com.github.gorkiiuss.program3.recursividad.binarysearchintree;

import java.util.Arrays;
import java.util.List;

public class BinarySearchInTree {
    public static void main(String[] args) {
        SearchTree<Integer> tree = new SearchTree<>();
        tree.buildBalancedTree(List.of(20, 10, 2, 56, 20, 1, 5, 90, 88, 13, 22, 11, 10, 77, 59));
        tree.printTree();
        int valueToSearch = 77;
        System.out.println("Value to search: " + valueToSearch);
        String[] steps = tree.searchRecursive(valueToSearch);
        System.out.println("Value was " + (steps == null ? "not " : "") + "found");
        System.out.println("Steps: " + Arrays.toString(steps));
    }
}
