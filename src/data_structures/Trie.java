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
 * Implementation of a Trie that uses a {@link HashMap}. This data structure
 * is useful for input validation type problems.
 */
public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode('*');
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            node.addChild(c);
            node = node.getChild(c);
        }
        
        if (!node.isWord()) {
            // Set the value of is word on the last to true
            node.setIsWord(true);
        }
    }
    
    public boolean containsWord(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            
            if (!node.hasChild(c)) {
                return false;
            }
            
            // Switch to the next node
            node = node.getChild(c);
        }
        return true;
    }
    
    private class TrieNode {
        private char value;
        private HashMap<Character, TrieNode> children;
        private int childCount;
        private boolean isWord;
        
        public TrieNode(char value) {
            this.value = value;
            children = new HashMap();
            childCount = 0;
            isWord = false;
        }
        
        public char getValue() {
            return value;
        }
        
        public void addChild(char c) {
            if (children.get(c) == null) {
                TrieNode node = new TrieNode(c);
                children.put(c, node);
                childCount++;
            } else {
                System.out.println("Node for character " + value + " contains a node for character " + c);
            }
        }
        
        public boolean hasChild(char c) {
            return children.containsKey(c);
        }
        
        public TrieNode getChild(char c) {
            return children.get(c);
        }
        
        public int getChildCount() {
            return childCount;
        }
        
        public boolean isWord() {
            return isWord;
        }
        
        public void setIsWord(boolean isWord) {
            this.isWord = isWord;
            System.out.println("Setting the node with char " + value + " is word to " + isWord);
        }
    }
}
