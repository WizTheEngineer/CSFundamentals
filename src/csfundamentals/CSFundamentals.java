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
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(20);
        tree.insert(25);
        tree.insert(9);
        tree.insert(8, true);
    }
}
