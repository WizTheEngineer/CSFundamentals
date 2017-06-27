/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

/**
 *
 * @author Wayne
 * Collection of Bit Manipulation solution from "Cracking the Coding Interview".
 */
public class BitManipulation {
    
    /**
     * Inserts the number m into n starting at j and ending at i. It can be assumed
     * that j through i will fit m.
     * @param n
     * @param m
     * @param i
     * @param j
     * @return 
     */
    public static int insertion(int n, int m, int i, int j) {
        int size = (j - i) + 1;
        // We need to create a clear mask from positions j through i, for example
        // if j = 6 and i = 2 we would need the mask 10000011
        int clearMask = ~((-1 >>> 31 - size) << i);
        int clearedN = n & clearMask;
        
        // Now we need to or the cleared n with m shifted i positions to the left
        int shiftedM = m << i;
        return clearedN | shiftedM;
    }
    
    /**
     * Returns the binary string representation of a double between the values
     * of 1 and 0. The string can be no longer than 32 characters.
     * @param d
     * @return 
     */
    public static String binaryStringFromDouble(double d) {
        if (d < 0.0d || d > 1.0d) return "ERROR";
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        
        while (d > 0.0d) {
            if (sb.length() > 32) {
                return "ERROR";
            }
            
            d *= 2.0d;
            if (d >= 1.0d) {
                sb.append(1);
                d -= 1.0d;
            } else {
                sb.append(0);
            }
        }
        return sb.toString();
    }
}
