package com.ejemplo;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node root;

    private class Node {
        E data;
        Node left;
        Node right;

        Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(E element) {
        root = insertRecursive(root, element);
    }

    private Node insertRecursive(Node current, E element) {
        if (current == null) {
            return new Node(element);
        }

        int compareResult = element.compareTo(current.data);

        if (compareResult < 0) {
            current.left = insertRecursive(current.left, element);
        } else if (compareResult > 0) {
            current.right = insertRecursive(current.right, element);
        }

        return current;
    }

    public E search(E key) {
        Node result = searchRecursive(root, key);
        return result != null ? result.data : null;
    }

    private Node searchRecursive(Node current, E key) {
        if (current == null || current.data.equals(key)) {
            return current;
        }

        int compareResult = key.compareTo(current.data);

        if (compareResult < 0) {
            return searchRecursive(current.left, key);
        } else {
            return searchRecursive(current.right, key);
        }
    }

    public List<E> inorderTraversal() {
        List<E> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }

    private void inorderRecursive(Node node, List<E> result) {
        if (node != null) {
            inorderRecursive(node.left, result);
            result.add(node.data);
            inorderRecursive(node.right, result);
        }
    }
}