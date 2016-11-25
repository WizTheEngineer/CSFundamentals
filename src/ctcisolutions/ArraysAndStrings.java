/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import java.util.Arrays;

/**
 *
 * @author Wayne
 */
public class ArraysAndStrings {

    // #1 Is Unique
    public static boolean isUnique(String source) {
        int[] count = new int[128];

        for (int i = 0; i < source.length(); i++) {
            if (count[source.charAt(i)] > 0) {
                return false;
            }

            count[source.charAt(i)] = count[source.charAt(i)] + 1;
        }
        return true;
    }

    public static boolean isUniqueNoBuffer(String source) {
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);

            for (int j = i + 1; j < source.length(); j++) {
                if (source.charAt(j) == c) {
                    return false;
                }
            }
        }
        return true;
    }

    // #2 Check Permutation
    public static boolean isPermutation(String one, String two) {
        if (one == null || two == null) {
            throw new IllegalArgumentException("Strings cannot be null");
        }
        if (one.length() != two.length()) {
            return false;
        }

        // Count the characters in the first string
        int[] countArray = new int[128]; // Assuming ascii
        for (int i = 0; i < one.length(); i++) {
            countArray[one.charAt(i)] = countArray[one.charAt(i)] + 1;
        }

        // Verify character counts are the same in the second string
        for (int i = 0; i < two.length(); i++) {
            int count = countArray[two.charAt(i)];
            if (count == 0) {
                return false;
            }
            countArray[two.charAt(i)] = count - 1;
        }
        return true;
    }

    // #3 URLify
    public static String urlrify(String source, int length) {
        if (source == null) {
            throw new IllegalArgumentException("String cannel be null");
        }
        if (length == 0) {
            return source;
        }

        char[] str = source.toCharArray();
        int spaceCount = 0, newLength, i;

        // Count the spaces
        for (i = 0; i < length; i++) {
            if (str[i] == ' ') {
                spaceCount += 1;
            }
        }

        // Work backwards and build the new string
        newLength = length + (spaceCount * 2);
        for (i = length - 1; i >= 0; i--) {
            char c = str[i];
            if (c == ' ') {
                str[newLength - 1] = '0';
                str[newLength - 2] = '2';
                str[newLength - 3] = '%';
                newLength -= 3;
            } else {
                str[newLength - 1] = c;
                newLength -= 1;
            }
        }

        return String.valueOf(str);
    }

    // #4 Palindrome Permutation
    public static boolean isPalindromePermutation(String source) {
        if (source == null) {
            throw new IllegalArgumentException("Parameters cannot be null");
        }

        char[] str = source.toLowerCase().toCharArray();

        // Sort the array
        Arrays.sort(str);

        // There can only be one odd character count in a palindrome
        boolean oddFound = false;
        int count = 0;
        char lastSeen = Character.MIN_VALUE;

        for (int i = 0; i < str.length; i++) {
            char c = str[i];

            if (c != ' ') {
                if (c != lastSeen) {
                    if (count % 2 != 0) {
                        if (oddFound) {
                            return false;
                        }
                        oddFound = true;
                    }

                    lastSeen = c;
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        return true;
    }
    
    // #5 One Edit Away
    public static boolean isOneEditAway(String one, String two) {
        if (one == null || two == null) throw new IllegalArgumentException("Strings cannot be null");
        int oneLength = one.length();
        int twoLength = two.length();
        
        if (Math.abs(oneLength - twoLength) > 1) {
            // Since the length difference is greater than 1, there is no way
            // these two string are one edit away.
            return false;
        } else if (oneLength == twoLength) {
            // Potential replace a character edit
            return checkForReplaceEdit(one, two);
        } else {
            // Potential remove or insert a character edit
            return checkForRemoveInsertEdit(one, two);
        }
    }
    
    private static boolean checkForReplaceEdit(String one, String two) {
        // The diffence can be at most one character
        boolean differenceFound = false;
        int length = one.length();
        
        for (int i = 0; i < length; i++) {
            if (one.charAt(i) != two.charAt(i)) {
                if (differenceFound) {
                    return false;
                }
                
                differenceFound = true;
            }
        }
        return true;
    }
    
    private static boolean checkForRemoveInsertEdit(String one, String two) {
        if (Math.abs(one.length() - two.length()) > 1) return false;
  
        String longerString = one.length() > two.length() ? one : two;
        String shorterString = one.length() < two.length() ? one : two;
        
        int difference = 0;
        int i = 0;
        int j = i;
        
        while (i < longerString.length() && j < shorterString.length()) {
            if (longerString.charAt(i) == shorterString.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
                difference++;
            }
        }
        
        difference += longerString.length() - i;
        
        return difference <= 1;
    }
    
    // #6 String Compression
    public static String compressString(String source) {
        if (source == null) throw new IllegalArgumentException("String cannot be null");
        if (source.isEmpty()) return source;
        StringBuilder builder = new StringBuilder();
        
        int count = 0;
        char lastSeen = source.charAt(0);
        
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            
            // This is case insensitive so convert upper case letters to lowercase
            if ('A' <= c && c <= 'Z') {
                c = Character.toLowerCase(c);
            }
            if (c != lastSeen) {
                builder.append(lastSeen);
                builder.append(count);
                count = 1;
                lastSeen = c;
            } else {
                count++;
            }
        }
        
        builder.append(lastSeen);
        builder.append(count);
        
        String output = builder.toString().length() < source.length() ? 
                builder.toString() : source;
        return output;
    }
}
