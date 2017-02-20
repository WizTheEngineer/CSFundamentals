/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.TreesAndGraphs;
import ctcisolutions.TreesAndGraphs.SpecialNode;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] inorder = {10, 30, 40, 50, 60, 70, 80};
        int[] preorder = {50, 30, 10, 40, 70, 60, 90};
        SpecialNode root = TreesAndGraphs.buildTree(preorder, inorder);
        root.printInorder();
    }
}
