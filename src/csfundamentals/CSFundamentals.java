/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import algorithms.Sorts;

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
        Sorts sorts = new Sorts();
        int[] array = {7, 5, 2, 8, 1, 9, 4, 7, 2, 3, 6};
        printArray(array);
        sorts.quickSort(array);
        printArray(array);
    }
    
    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("| %d |", array[i]);
        }
        System.out.println();
    }
}
