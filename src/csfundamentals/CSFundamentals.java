/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.RecursionAndDynamicProgramming;
import java.util.List;


/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
        public static void main(String[ ] args) {
            int[] coins = new int[] {25, 10, 5, 1};
            long ways = RecursionAndDynamicProgramming.makeChange(50, coins);
            System.out.println("" + ways);
        }
}
