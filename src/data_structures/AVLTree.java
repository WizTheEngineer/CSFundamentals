/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import data_structures.utils.TreePrinter;

/**
 *
 * @author Wayne
 * @param <T>
 */
public class AVLTree<T> {

    private AVLNode<T> root;

    private static class AVLNode<T> implements PrintableNode {

        private final T data;
        private int height;
        private AVLNode<T> left;
        private AVLNode<T> right;

        private AVLNode(T data) {
            this.data = data;
            height = 1;
        }

        @Override
        public PrintableNode getLeft() {
            return left;
        }

        @Override
        public PrintableNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return data.toString();
        }
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private AVLNode<T> insert(AVLNode<T> node, T value) {
        if (node == null) {
            node = new AVLNode(value);
            return node;
        } else {
            int k = ((Comparable) node.data).compareTo(value);
            if (k > 0) {
                node.left = insert(node.left, value);
            } else {
                node.right = insert(node.right, value);
            }
            node.height = Math.max(height(node.left), height(node.right)) + 1;
            int heightDiff = heightDiff(node);
            if (heightDiff < -1) {
                if (heightDiff(node.right) > 0) {
                    node.right = rightRotate(node.right);
                    return leftRotate(node);
                } else {
                    return leftRotate(node);
                }
            } else if (heightDiff > 1) {
                if (heightDiff(node.left) < 0) {
                    node.left = leftRotate(node.left);
                    return rightRotate(node);
                } else {
                    return rightRotate(node);
                }
            } else;

        }
        return node;
    }

    private AVLNode<T> leftRotate(AVLNode<T> n) {
        AVLNode<T> r = n.right;
        n.right = r.left;
        r.left = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return r;
    }

    private AVLNode<T> rightRotate(AVLNode<T> n) {
        AVLNode<T> r = n.left;
        n.left = r.right;
        r.right = n;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return r;
    }

    private int heightDiff(AVLNode<T> a) {
        if (a == null) {
            return 0;
        }
        return height(a.left) - height(a.right);
    }

    private int height(AVLNode<T> a) {
        if (a == null) {
            return 0;
        }
        return a.height;
    }
    
    public void printInorder() {
        printInorder(root);
    }
    
    private void printInorder(AVLNode node) {
        if (node == null) {
            return;
        }
        printInorder(node.left);
        System.out.println(node.data);
        printInorder(node.right);
    }
    
    public void printPretty() {
        TreePrinter.print(root);
    }
}
