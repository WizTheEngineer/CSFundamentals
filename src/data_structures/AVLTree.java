/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

public class AVLTree {
    
    private Node root;
    
    public Node insert(int data) {
        root = insert(data, false);
        return root;
    }
    
    public Node insert(int data, boolean print) {
        root = insert(root, data, print);
        if (print) {
            printInorder(root);
        }
        return root;
    }
    
    /**
     * Recursive function to insert a node into a BST.
     * @param parent
     * @param data
     * @param print
     * @return 
     */
    private Node insert(Node parent, int data, boolean print) {
        if (parent == null) {
            parent = new Node(data);
        } else if (data <= parent.data) {
            parent.left = insert(parent.left, data, print);
        } else {
            parent.right = insert(parent.right, data, print);
        }
        
        final int balanceFactor = getBalanceFactor(parent);
        if (Math.abs(balanceFactor) > 1) {
            if (balanceFactor < 0) {
                if (parent.left.left != null) {
                    // LL-Inbalance
                    parent = rightRotate(parent);
                } else {
                    // LR-Inbalance
                    parent.left = leftRotate(parent.left);
                    parent = rightRotate(parent);
                }
            } else {
                if (parent.right.right != null) {
                    // RR-Inbalance
                    parent = leftRotate(parent);
                } else {
                    // RL-Inbalance
                    parent.right = rightRotate(parent.right);
                    parent = leftRotate(parent);
                }
            }
        }
        return parent;
    }
    
    /**
     * Returns the height of a given node, if null returns -1
     * @param node
     * @return 
     */
    private int getHeight(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(getHeight(node.right), getHeight(node.left));
    }
    
    /**
     * Returns the balance factor (BF) of the left and right subtrees of a given
     * node. If BF is less than 0 the subtree is left heavy. If BF 
     * is greater than 0 the subtree is right heavy. If BF equals 0 the subtree 
     * is balanced.
     * @param node
     * @return 
     */
    private int getBalanceFactor(Node node) {
        return getHeight(node.right) - getHeight(node.left);
    }
    
    /**
     * Executes a right-rotate on a node.
     * @param node
     * @return 
     */
    private Node rightRotate(Node node) {
        System.out.printf("Right rotate node: %d\n", node.data);
        Node left = node.left;
        node.left = null;
        left.right = node;
        return left;
    }
    
    /**
     * Executes a left-rotate on a node.
     * @param node
     * @return 
     */
    private Node leftRotate(Node node) {
        System.out.printf("Left rotate node: %d\n", node.data);
        Node right = node.right;
        node.right = null;
        right.left = node;
        return right;
    }
    
    /**
     * Prints the in-order traversal of this tree.
     * @param node 
     */
    public void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        final int height = getHeight(node);
        final int balanceFactor = getBalanceFactor(node);
        System.out.printf("(data: %d, height: %d, balanceFactor: %d)\n", 
                node.data, height, balanceFactor);
        printInorder(node.right);
    }
    
    /**
     * Node class for AVL Tree.
     */
    private class Node {
        public int data;
        public Node left;
        public Node right;
        
        public Node(int data) {
            this.data = data;
        }
    }
}
