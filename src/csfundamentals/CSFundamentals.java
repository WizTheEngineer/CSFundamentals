/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.ArraysAndStrings;
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
            int[][] matrix = new int[5][5];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) (Math.random() * 9 + 1);
                }
            }
            System.out.println("-----Before Rotate------\n");
            print2dArray(matrix);
            System.out.print("\n\n");
            ArraysAndStrings.rotateMatrix(matrix);
            System.out.println("-----After Rotate------\n");
            print2dArray(matrix);
            System.out.println();
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
