/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.TreesAndGraphs.Node;
import interview_qs.AnagramUtils;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    static final String[] testArray = new String[] {"ab", "ba", "abc", "def", "bac", "defe", "cab", "bac", "ll;", "   ", ""};

    /**
     * @param args the command line arguments
     */
        public static void main(String[ ] args) {
            AnagramUtils.printAnagrams(testArray);
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
