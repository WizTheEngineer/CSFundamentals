/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.RecursionAndDynamicProgramming;
import java.util.ArrayList;


/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
        public static void main(String[ ] args) {
            long a = -421234;
            long b = -85345;
            long product = RecursionAndDynamicProgramming.multiply(a, b);
            System.out.printf("The product of %d and %d is %d\n", a, b, product);
        }
}
