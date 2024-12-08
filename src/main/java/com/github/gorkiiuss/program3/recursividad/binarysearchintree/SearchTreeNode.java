package com.github.gorkiiuss.program3.recursividad.binarysearchintree;

public class SearchTreeNode<T extends Comparable<T>> {
    T value;
    SearchTreeNode<T> left;
    SearchTreeNode<T> right;

    public SearchTreeNode(T value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

