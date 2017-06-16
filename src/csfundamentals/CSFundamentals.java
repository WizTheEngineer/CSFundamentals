/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.RecursionAndDynamicProgramming;
import java.util.ArrayList;
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
            String s = "dog";
            List<String> permutations = RecursionAndDynamicProgramming.getPerms(s);
            for (String perm : permutations) {
                System.out.println(perm);
            }
        }
}
