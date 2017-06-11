/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Wayne
 * Collection of solutions for "Cracking the Coding Interview" related
 * to recursion and dynamic programming.
 */
public class RecursionAndDynamicProgramming {
    
    // #1 Triple Step
    public static long countWays(int n) {
        long[] memo = new long[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n, memo);
    }
    
    private static long countWays(int n, long[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;
        if (memo[n] != -1) {
            System.out.println("Returning countWays(" + n + "} from memo");
            return memo[n];
        }
        long ways = countWays(n - 3, memo) + countWays(n - 2, memo) + countWays(n - 1, memo);
        memo[n] = ways;
        return ways;
    }
    
    // #3 Magic Index
    public static int magicIndex(int[] a) {
        if (a == null || a.length == 0) return -1;
        return magicIndex(a, 0, a.length - 1);
    }
    
    // Assumes sorted and distinct
    private static int magicIndex(int[] a, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int k = a[mid];
        if (k == mid) {
            return k;
        }
        if (k < mid) {
            return magicIndex(a, mid + 1, end);
        }
        return magicIndex(a, start, mid - 1);
    }
    
    // Assumes sorted but not guaranteed distinct
    private static int magicIndexNotDistinct(int[] a, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int k = a[mid];
        if (k == mid) {
            return k;
        }
        
        // Search the left
        int leftEnd = Math.min(mid - 1, k);
        int left = magicIndexNotDistinct(a, start, leftEnd);
        if (left >= 0) {
            return left;
        }
        
        // Search the right
        int rightStart = Math.max(mid + 1, k);
        int right = magicIndexNotDistinct(a, rightStart, end);
        return right;
    }
    
    // #4 Power Set
    public static ArrayList<ArrayList<Character>> powerSet(ArrayList<Character> set) {
        if (set == null) return null;
        ArrayList<ArrayList<Character>> powerSet = new ArrayList<ArrayList<Character>>();
        
        // Add the empty set
        ArrayList<Character> emptySet = new ArrayList<>();
        emptySet.add(' ');
        powerSet.add(emptySet);
       
        return powerSet(set, powerSet, 0);
    }
    
    private static ArrayList<ArrayList<Character>> powerSet(ArrayList<Character> set, ArrayList<ArrayList<Character>> powerSet, int current) {
        if (current >= set.size()) return powerSet;
        ArrayList<ArrayList<Character>> moreSubSets = new ArrayList<ArrayList<Character>>();
        char currElement = set.get(current);
        
        for (ArrayList<Character> s : powerSet) {
            ArrayList<Character> newS = new ArrayList<>();
            newS.addAll(s);
            newS.add(currElement);
            moreSubSets.add(newS);
        }
        
        powerSet.addAll(moreSubSets);
        powerSet = powerSet(set, powerSet, current + 1);
        return powerSet;
    }
}
