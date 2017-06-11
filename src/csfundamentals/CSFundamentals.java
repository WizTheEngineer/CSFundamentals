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
            int[] a = new int[] {-5, -2, 2, 4, 5, 8, 9};
            ArrayList<Character> set = new ArrayList<>();
            set.add('a');
            set.add('b');
            set.add('c');
            ArrayList<ArrayList<Character>> powerSet = 
                    RecursionAndDynamicProgramming.powerSet(set);
            System.out.println("" + powerSet.size());
        }
}
