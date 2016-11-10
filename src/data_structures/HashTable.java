/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.List;

/**
 *
 * @author Wayne
 * HashTable implementation that uses chaining for collisions.
 */
public class HashTable<K, V> {
    private static final int MIN_SIZE = 100;
    
    private int size;
    private List<KeyValuePair>[] values;
    
    public HashTable(int size) {
        if (size < MIN_SIZE) {
            throw new IllegalArgumentException("Minimum size of HashTable must be " + MIN_SIZE);
        }
        this.size = size;
        initValues();
    }
    
    public V get(K key) {
        int index = getIndexForKey(key);
        List<KeyValuePair> list = values[index];
        
        if (list == null) {
            // Index for this key doesn't exist
            return null;
        }
        
        for (KeyValuePair<K, V> keyValuePair : list) {
            if (keyValuePair.getKey().equals(key)) {
                return keyValuePair.getValue();
            }
        }
        return null;
    }
    
    public void put(K key, V value) {
        KeyValuePair keyValuePair = new KeyValuePair(key, value);
        int index = getIndexForKey(key);
       
        if (slotIsEmptyAtIndex(index)) {
            // There was no collision. Initialize the slot with a linked list, 
            // (Note: This could be further optimized by initializing the slot 
            // with just the key value pair.)
            List<KeyValuePair> list = list = new java.util.ArrayList();
            list.add(keyValuePair);
            values[index] = list;
        } else {
            // There was a collision, handle it.
            List<KeyValuePair> list = values[index];
            
            // Check that the key is not used
            for (int i = 0; i < list.size(); i++) {
                KeyValuePair<K, V> kVP = list.get(i);
                if (kVP.getKey().equals(key)) {
                    
                    // Remove the object from the list
                    list.remove(i);
                    
                    // Add the new item where the old item was
                    list.add(i, keyValuePair);
                    return;
                }
            }
            
            // If we made it here the key is unused
            list.add(keyValuePair);
        }
    }
    
    /**
     * Checks if the slot has ever been used for a given index.
     * @param index
     * @return 
     */
    private boolean slotIsEmptyAtIndex(int index) {
        return values[index] == null;
    }
    
    /**
     * Creates value array and ensures all default values are null. This is 
     * useful for later checking if a slot is empty.
     */
    private void initValues() {
        values = new List[size];
        for (int i = 0; i < values.length; i++) {
            values[i] = null;
        }
    }
    
    /**
     * Calculates hash code and uses that to return an index for a given key.
     * @param key
     * @return 
     */
    private int getIndexForKey(K key) {
        // Uses Java's built in hashcode function
        return Math.abs(key.hashCode() % size);
    }
    
    public class KeyValuePair<K, V> {
        private K key;
        private V value;
    
        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    
        public K getKey() {
            return key;
        }
    
        public V getValue() {
            return value;
        }
    }
}
