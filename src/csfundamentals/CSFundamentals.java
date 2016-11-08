/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import data_structures.Heap;
import data_structures.Heap.Type;
import data_structures.Trie;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        executeTrieExample();
    }
    
    private static void executeHeapExample() {
        Heap heap = new Heap(Type.MIN);
        heap.add(12);
        heap.add(11);
        heap.add(14);
        heap.add(2);
        heap.add(5);
        heap.add(1);
        heap.add(11);
        heap.add(4);
        heap.add(13);
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
        heap.poll();
        System.out.println("");
        heap.printValues();
    }
    
    private static void executeTrieExample() {
        Trie trie = new Trie();
        trie.addWord("Wayne");
        trie.addWord("Worry");
        trie.addWord("Wallie");
        trie.addWord("Brandi");
        trie.addWord("Brittney");
        trie.addWord("Brand");
        
        if (trie.containsWord("Wow")) {
            System.out.println("The trie contains Wow");
        } else {
            System.out.println("The trie doesn't contain Wow");
        }
        
        if (trie.containsWord("Brandi")) {
            System.out.println("This trie contains Brandi");
        } else {
            System.out.println("The trie doesn't contain Brandi");
        }
    }
    
}
