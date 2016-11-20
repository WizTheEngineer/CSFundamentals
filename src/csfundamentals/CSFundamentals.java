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
        avlTree.insert(25);
        avlTree.insert(12);
        avlTree.insert(17);
        avlTree.insert(15);
        avlTree.insert(10);
        avlTree.insert(20);
        avlTree.insert(8);
        avlTree.insert(6);
        avlTree.insert(28);
        avlTree.insert(11);
        avlTree.insert(16);
        avlTree.insert(27);
        avlTree.printPretty();
        printSuccessors(avlTree);
        
    }
    
    private static void printSuccessors(AVLTree avlTree) {
        for (int i = 0; i < 30; i++) {
            int value = i;
            
            if (avlTree.successor(value) != null) {
                System.out.printf("Successor to %d is %d\n", value, avlTree.successor(value));
            }
        }
    }
}
