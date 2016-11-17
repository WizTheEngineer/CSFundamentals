/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import data_structures.utils.TreePrinter;
import com.sun.istack.internal.Nullable;
import data_structures.interfaces.BalancedBST;

/**
 *
 * @author Wayne
 */
public class AVLTree implements BalancedBST {
    
    private AVLNode root;
    
    public AVLTree() {
        root = null;
    }

    @Override
    public void insert(Integer data) {
        if (root == null) {
            root = new AVLNode(null, data);
        } else {
            AVLNode current = root;
            
            while (true) {
                if (data <= current.data) {
                    if (current.left == null) {
                        AVLNode newNode = new AVLNode(current, data);
                        current.left = newNode;
                        current = newNode;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        AVLNode newNode = new AVLNode(current, data);
                        current.right = newNode;
                        current = newNode;
                        break;
                    }
                    current = current.right;
                }
            }
            
            while (current != null) {
                int balance = current.getBalance();
                
                if (Math.abs(balance) > 1) {
                    // This subtree is unbalanced, let's find out how.
                    if (balance > 0) {
                        // The left subtree is unbalanced
                        int childBalance = current.left.getBalance();
                        
                        if (childBalance > 0) {
                            rightRotate(current); // LL
                        } else {
                            leftRotate(current.left); // LR
                            rightRotate(current);
                        }
                    } else {
                        // The right subtree is unbalanced
                        int childBalance = current.right.getBalance();
                        
                        if (childBalance > 0) {
                            rightRotate(current.right); // RL
                            leftRotate(current);
                        } else {
                            leftRotate(current); // RR
                        }
                    }
                }
                current = current.parent;
            }
        }
    }
    
    private void rightRotate(AVLNode root) {
        AVLNode newRoot = root.left;
        AVLNode newRootParent = root.parent;
        root.left = null;
        newRoot.right = root;
        root.parent = newRoot;
        
        if (newRootParent != null) {
            if (newRoot.data <= newRootParent.data) {
                newRootParent.left = newRoot;
            } else {
                newRootParent.right = newRoot;
            }
            newRoot.parent = newRootParent;
        } else {
            newRoot.parent = null;
            this.root = newRoot;
        }
    }
    
    private void leftRotate(AVLNode root) {
        AVLNode newRoot = root.right;
        AVLNode newRootParent = root.parent;
        root.right = null;
        newRoot.left = root;
        root.parent = newRoot;
        
        if (newRootParent != null) {
            if (newRoot.data <= newRootParent.data) {
                newRootParent.left = newRoot;
            } else {
                newRootParent.right = newRoot;
            }
            newRoot.parent = newRootParent;
        } else {
            newRoot.parent = null;
            this.root = newRoot;
        }
    }

    @Override
    public void delete(Integer data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getMin() {
        if (root == null) {
            return null;
        }
        
        // The minimum value in a binary tree is the leftmost value
        AVLNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.left.data;
    }

    @Override
    public Integer getMax() {
        if (root == null) {
            return null;
        }
        
        // The maximum value in a binary tree is the rightmost value
        AVLNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.right.data;
    }

    @Override
    public Integer getSuccessor(Integer data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getPredecessor(Integer data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void printInorder() {
        printPretty();
    }
    
    private void printTree(AVLNode node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.data);
            printTree(node.right);
        }
    }
    
    private void printPretty() {
        TreePrinter.print(root);
    }
    
    private boolean isEmpty() {
        return root == null;
    }
    
    private class AVLNode implements PrintableNode {
        TreePrinter treePrinter;
        Integer data;
        AVLNode parent, left, right;
        
        public AVLNode(@Nullable AVLNode parent, Integer data) {
            this.parent = parent;
            this.data = data;
        }
        
        public int getHeight() {
            if (left == null && right == null) {
                return 1;
            } else if (left == null) {
                return right.getHeight() + 1;
            } else if (right == null) {
                return left.getHeight() + 1;
            } else {
                return Math.max(right.getHeight(), left.getHeight()) + 1;
            }
        }
        
        private int getLeftSubTreeHeight() {
            if (left == null) {
                return 0;
            }
            return left.getHeight();
        }
        
        private int getRightSubTreeHeight() {
            if (right == null) {
                return 0;
            }
            return right.getHeight();
        }
        
        /***
         * Return a value > 0 if the left subtree is taller a value < 0 if the 
         * right subtree is taller and 0 if the left and right subtree are even 
         * in height.
         * @return 
         */
        public int getBalance() {
            return getLeftSubTreeHeight() - getRightSubTreeHeight();
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
            return String.valueOf(data);
        }
    }
}
