package com.github.gorkiiuss.program3.recursividad.binarysearchintree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchTree<T extends Comparable<T>> {
    private SearchTreeNode<T> root;

    public SearchTree() {
        this.root = null;
    }

    /**
     * Construye un árbol de búsqueda balanceado a partir de una lista desordenada.
     * Primero ordena la lista y luego construye el árbol de manera que el elemento
     * mediano sea la raíz.
     */
    public void buildBalancedTree(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            return;
        }

        // Eliminar duplicados y ordenar
        List<T> sortedElements = new ArrayList<>(elements);
        Collections.sort(sortedElements);
        // Opcional: eliminar duplicados
        sortedElements = removeDuplicates(sortedElements);

        this.root = buildBalancedTreeRecursive(sortedElements, 0, sortedElements.size() - 1);
    }

    private SearchTreeNode<T> buildBalancedTreeRecursive(List<T> sortedElements, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        SearchTreeNode<T> node = new SearchTreeNode<>(sortedElements.get(mid));

        node.left = buildBalancedTreeRecursive(sortedElements, start, mid - 1);
        node.right = buildBalancedTreeRecursive(sortedElements, mid + 1, end);

        return node;
    }

    private List<T> removeDuplicates(List<T> sortedElements) {
        List<T> unique = new ArrayList<>();
        T previous = null;
        for (T element : sortedElements) {
            if (previous == null || !element.equals(previous)) {
                unique.add(element);
                previous = element;
            }
        }
        return unique;
    }

    /**
     * Inserta un nuevo elemento en el árbol de búsqueda.
     * Si el árbol está balanceado y se desea mantenerlo balanceado,
     * es recomendable reconstruir el árbol después de múltiples inserciones.
     */
    public void insert(T value) {
        if (root == null) {
            root = new SearchTreeNode<>(value);
            return;
        }

        SearchTreeNode<T> current = root;
        SearchTreeNode<T> parent = null;

        while (current != null) {
            parent = current;
            if (value.compareTo(current.value) < 0) {
                current = current.left;
            } else if (value.compareTo(current.value) > 0) {
                current = current.right;
            } else {
                // Valor ya existe en el árbol, no se insertan duplicados
                return;
            }
        }

        if (value.compareTo(parent.value) < 0) {
            parent.left = new SearchTreeNode<>(value);
        } else {
            parent.right = new SearchTreeNode<>(value);
        }
    }

    /**
     * Busca un elemento en el árbol de búsqueda.
     * @param value El valor a buscar.
     * @return true si el elemento existe, false en caso contrario.
     */
    public String[] searchIterative(T value) {
        SearchTreeNode<T> current = root;
        List<String> steps = new ArrayList<>();
        while (current != null) {
            if (value.compareTo(current.value) == 0) {
                return steps.toArray(new String[0]);
            } else if (value.compareTo(current.value) < 0) {
                current = current.left;
                steps.add("left");
            } else {
                current = current.right;
                steps.add("right");
            }
        }
        return null;
    }

    public String[] searchRecursive(T value) {
        return searchRecursive(value, root, new String[0]);
    }

    public String[] searchRecursive(T value, SearchTreeNode<T> current, String[] steps) {
        if (current == null) return null;
        if (value.compareTo(current.value) == 0) return steps;
        if (value.compareTo(current.value) < 0) {
            String[] newSteps = Arrays.copyOf(steps, steps.length + 1);
            newSteps[newSteps.length - 1] = "left";
            return searchRecursive(value, current.left, newSteps);
        } else {
            String[] newSteps = Arrays.copyOf(steps, steps.length + 1);
            newSteps[newSteps.length - 1] = "right";
            return searchRecursive(value, current.right, newSteps);
        }
    }

    /**
     * Realiza un recorrido en orden (In-Order Traversal) del árbol.
     * @return Una lista con los elementos en orden ascendente.
     */
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderRecursive(root, result);
        return result;
    }

    private void inOrderRecursive(SearchTreeNode<T> node, List<T> result) {
        if (node != null) {
            inOrderRecursive(node.left, result);
            result.add(node.value);
            inOrderRecursive(node.right, result);
        }
    }

    /**
     * Realiza un recorrido preorden (Pre-Order Traversal) del árbol.
     * @return Una lista con los elementos en preorden.
     */
    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderRecursive(root, result);
        return result;
    }

    private void preOrderRecursive(SearchTreeNode<T> node, List<T> result) {
        if (node != null) {
            result.add(node.value);
            preOrderRecursive(node.left, result);
            preOrderRecursive(node.right, result);
        }
    }

    /**
     * Realiza un recorrido postorden (Post-Order Traversal) del árbol.
     * @return Una lista con los elementos en postorden.
     */
    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderRecursive(root, result);
        return result;
    }

    private void postOrderRecursive(SearchTreeNode<T> node, List<T> result) {
        if (node != null) {
            postOrderRecursive(node.left, result);
            postOrderRecursive(node.right, result);
            result.add(node.value);
        }
    }

    /**
     * Método para imprimir el árbol de manera visual.
     */
    public void printTree() {
        printTreeRecursive(root, 0);
    }

    private void printTreeRecursive(SearchTreeNode<T> node, int level) {
        if (node != null) {
            printTreeRecursive(node.right, level + 1);
            System.out.println(" ".repeat(4 * level) + "-> " + node.value);
            printTreeRecursive(node.left, level + 1);
        }
    }
}

