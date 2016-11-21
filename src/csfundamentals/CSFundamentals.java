/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import data_structures.AVLTree;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AVLTree<Integer> avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(15); 
        avlTree.insert(5);
        avlTree.insert(13);
        avlTree.insert(40);
        avlTree.insert(11);
        avlTree.insert(-29);
        printMax(avlTree);
        printMin(avlTree);
        
        
    }
    
    private static void printMax(AVLTree avlTree) {
        System.out.println("The max value of the tree is " + avlTree.findMax());
    }
    
    private static void printMin(AVLTree avlTree) {
        System.out.println("The minimum of the tree is " + avlTree.findMin());
    }
    
    private static void printSuccessors(AVLTree avlTree) {
        for (int i = 0; i < 30; i++) {
            int value = i;
            
            if (avlTree.successor(value) != null) {
                System.out.printf("Successor to %d is %d\n", value, avlTree.successor(value));
            }
        }
    }
    
    private static void printPredecessors(AVLTree avlTree) {
        for (int i = 30; i >= 0; i--) {
            int value = i;
            
            if (avlTree.predecessor(value) != null) {
                System.out.printf("Predecessor to %d is %d\n", value, avlTree.predecessor(value));
            }
        }
    }
}
