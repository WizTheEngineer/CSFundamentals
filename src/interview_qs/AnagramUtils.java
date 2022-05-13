package interview_qs;

import java.util.*;

public class AnagramUtils {

    public static void printAnagrams(final String[] words) {

        // Build anagrams map
        final Map<String, List<String>> anagramMap = new HashMap<>();
        final Set<String> keySet = new HashSet<>();
        for (String word : words) {
            try {
                final String key = generateKey(word);
                if (!anagramMap.containsKey(key)) {
                    final List<String> anagramList = new ArrayList<>();
                    anagramList.add(word);
                    anagramMap.put(key, anagramList);
                    keySet.add(key);
                } else {
                    anagramMap.get(key).add(word);
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Word " + word + " could not be processed for anagram." + e);
            }
        }

        // Print out anagrams
        for (String key : keySet) {
            final StringBuilder anagramsLine = new StringBuilder();
            final List<String> anagrams = anagramMap.get(key);

            for (int i = 0; i < anagrams.size(); i++) {
                final String word = anagrams.get(i);
                if (i > 0) {
                    anagramsLine.append(", ");
                }
                anagramsLine.append(word);
            }
            System.out.println(anagramsLine);
        }
    }

    /**
     * Assumes word contains only english alphabet. Otherwise, throws an exception.
     */
    private static String generateKey(final String word) throws IllegalArgumentException {
        if (word == null) {
            throw new IllegalArgumentException("Word must be non-null to generate key");
        }

        // Initialize character count map (value defaults to zero)
        final int[] charCountMap = new int[26];

        for (int i = 0; i < word.length(); i++) {
            final char c = Character.toLowerCase(word.charAt(i));
            final int index = c - 'a';

            // Check if index is valid (ie. character belongs to english alphabet)
            if (index < 0 || index >= charCountMap.length) {
                throw new IllegalArgumentException("Word must only contain letters of the english alphabet");
            }

            // Increment the character count
            charCountMap[index] = charCountMap[index] + 1;
        }

        // Use character count map to create unique key
        final StringBuilder keyBuilder = new StringBuilder();
        for (Integer charCount : charCountMap) {
            keyBuilder.append(charCount);
        }
        return keyBuilder.toString();
    }
}
