/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.RecursionAndDynamicProgramming;
import java.awt.Point;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;


/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
        public static void main(String[ ] args) {
            runPaintAlgorithm();
        }
        
        private static void runPaintAlgorithm() {
            int[][] screen = new int[10][15];
            for (int i = 0; i < screen.length; i++) {
                Arrays.fill(screen[i], (int)(Math.random() * 89) + 10);
            }
            print2dArray(screen);
            int col = (int)(Math.random() * screen.length - 1);
            int row = (int)(Math.random() * screen[0].length - 1);
            RecursionAndDynamicProgramming.paintFill(screen, new Point(col, row), (int)(Math.random() * 897635) + 1);
            System.out.print("\nPainted \n\n");
            print2dArray(screen);
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
}
