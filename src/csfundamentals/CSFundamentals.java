/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.LinkedLists;
import ctcisolutions.StacksAndQueues.ArrayThreeStack;
import data_structures.LinkedList;
import data_structures.Node;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayThreeStack<Integer> threeStack = new ArrayThreeStack<>(Integer.class, 300);
        threeStack.push(1, 20);
        threeStack.push(1, 30);
        threeStack.push(2, 30);
        threeStack.push(1, 40);
        threeStack.push(3, 20);
        threeStack.push(2, 50);
        threeStack.pop(3);
        
        for (int i = 1; i <= 3; i++) {
            System.out.println("Elements for stack: " + i);
            while (!threeStack.isEmpty(i)) {
                System.out.print(threeStack.pop(i) + " ");
            }
            System.out.println();
        }
    }
}
