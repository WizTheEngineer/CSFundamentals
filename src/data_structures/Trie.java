/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.HashMap;

/**
 *
 * @author Wayne
 * Implementation of a Trie that does not support duplicates.
 */
public class Trie {
    private final TrieNode root = new TrieNode(false);
    
    public Trie() {}
    
    public void addWord(String word) {
        // Make sure the word is not empty
        if (word.isEmpty()) {
            return;
        }
        
        // Make sure the word is not in this Trie
        if (containsWord(word)) {
            return;
        }
        
        // Start at the root
        TrieNode node = root;
        
        // Loop through and add the word to the Trie
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            boolean endOfWord = i == (word.length() - 1);
            node.addChild(c, endOfWord);
            node = node.getChild(c);
        }
    }
    
    public boolean containsWord(String word) {
        if (word.isEmpty()) {
            return false;
        }
        
        // Start at the root
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!node.hasChild(c)) {
                return false;
            }
            node = node.getChild(c);
        }
        
        return node.isEndOfWord();
    }
    
    /**
     * Returns the number of words contained in the Trie that start with a 
     * given prefix.
     * @param prefix
     * @return 
     */
    public int partialLookup(String prefix) {
        if (prefix.isEmpty()) {
            return 0;
        }
        
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            
            if (!node.hasChild(c)) {
                return 0;
            }
            
            node = node.getChild(c);
        }
        
        // If the node is an end of a word count it towards the total count
        if (node.isEndOfWord()) {
            return node.getChildCount() + 1;
        }
        return node.getChildCount();
    }
    
    private class TrieNode {
        private final HashMap<Character, TrieNode> children;
        private boolean endOfWord;
        private int childCount;
        
        public TrieNode(boolean endOfWord) {
            this.endOfWord = endOfWord;
            children = new HashMap();
            childCount = 0;
        }
        
        public void addChild(char c, boolean endOfWord) {
            TrieNode node;
            if (!children.containsKey(c)) {
                node = new TrieNode(endOfWord);
                children.put(c, node);
            } else {
                node = children.get(c);
                
                if (endOfWord) {
                    node.setIsEndOfWord(true);
                }
            }
            
            childCount++;
        }
        
        public boolean hasChild(char c) {
            return children.containsKey(c);
        }
        
        public TrieNode getChild(char c) {
            return children.get(c);
        }
        
        public boolean isEndOfWord() {
            return endOfWord;
        }
        
        public void setIsEndOfWord(boolean endOfWord) {
            this.endOfWord = endOfWord;
        }
        
        public int getChildCount() {
            return childCount;
        }
    }
}
