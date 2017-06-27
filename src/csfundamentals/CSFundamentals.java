/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.BitManipulation;
import ctcisolutions.TreesAndGraphs.Node;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
        public static void main(String[ ] args) {
            int result = BitManipulation.insertion(131, 7, 3, 5);
            double d = 0.375;
            System.out.println("Result of insertion " + result);
            System.out.println("The binary representation of " + d + " is "
            + BitManipulation.binaryStringFromDouble(d));
        }
        
        private static void print2dArray(int[][] array) {
            for (int i = 0; i < array.length; i++) {
                int[] row = array[i];
                for (int j = 0; j < row.length; j++) {
                    System.out.print("| " + row[j] + " |");
                }
                System.out.println();
            }
        }
        
        private static Node getNode(int value) {
            Node n = new Node();
            n.value = value;
            return n;
        }
}
