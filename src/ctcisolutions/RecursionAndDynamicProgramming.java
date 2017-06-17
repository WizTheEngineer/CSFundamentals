/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    // #5 Recursive Multiply (Doesn't deal with overflow, BigInteger should be used to handle overflow)
    public static long multiply(long a, long b) {
        long min = a < b ? a : b;
        long max = a > b ? a : b;
        boolean isNeg = min < 0 && max > 0;
        long product = recursiveMultiply(Math.abs(min), Math.abs(max));
        if (isNeg) {
            product -= (product + product);
        }
        return product;
    }
    
    private static long recursiveMultiply(long a, long b) {
        if (a == 0 || b == 0) return 0;
        long operations = 1;
        long result = a;
        while (operations + operations <= b) {
            result += result;
            operations += operations;
        }
        return result + recursiveMultiply(a, b - operations);
    }
    
    // #7 Permutations without Dups
    public static List<String> getPerms(String s) {
        if (s == null) return null;
        List<String> result = new ArrayList<>();
        getPerms("", s, result);
        return result;
    }
    
    private static void getPerms(String prefix, String remainder, List<String> result) {
        if (remainder.length() == 0) {
            result.add(prefix);
        }
        
        int length = remainder.length();
        for (int i = 0; i < length; i++) {
            String before = remainder.substring(0, i);
            String after = remainder.substring(i + 1, length);
            char c = remainder.charAt(i);
            RecursionAndDynamicProgramming.getPerms(prefix + c, before + after, result);
        }
    }
    
    // #8 Parens
    public static List<String> parenthesis(int n) {
        if (n <= 0) return null;
        char[] str = new char[n*2];
        List<String> result = new ArrayList<>();
        getParens(str, n, n, result, 0);
        return result;
    }
    
    private static void getParens(char[] str, int leftRemaining, int rightRemaining, List<String> result, int count) {
        if (leftRemaining < 0 || rightRemaining < leftRemaining) return; // Error state
        
        if (leftRemaining == 0 && rightRemaining == 0) {
            result.add(String.copyValueOf(str));
        } else {
            if (leftRemaining > 0) {
                str[count] = '(';
                getParens(str, leftRemaining - 1, rightRemaining, result, count + 1);
            }
            
            if (rightRemaining > leftRemaining) {
                str[count] = ')';
                getParens(str, leftRemaining, rightRemaining - 1, result, count + 1);
            }
        }
    }
    
    // #11 Coins
    public static long makeChange(int amount, int[] coins) {
        return makeChange(amount, coins, 0, new HashMap<String, Long>());
    }
    
    private static long makeChange(int amount, int[] coins, int index, HashMap<String, Long> memo) {
        if (amount == 0) {
            return 1;
        }
        if (index >= coins.length) {
            return 0;
        }
        final String key = String.format("%d_%d", amount, index);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        long ways = 0;
        int coin = coins[index];
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - (i * coin);
            ways += makeChange(remaining, coins, index + 1, memo);
        }
        memo.put(key, ways);
        return ways;
    }
}
