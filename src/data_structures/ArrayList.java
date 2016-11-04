/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.lang.reflect.Array;

/**
 *
 * @author Wayne
 * Represents a dynamically resizing array.
 */
public class ArrayList<T> {
    
    // Determines the factor that the capacity increases by
    private static final int CAPACITY_MULTIPLIER = 2;
    
    private final Class<T> elementType;
    private int numElements;
    private int capacity;
    private T[] elements;
    
    public ArrayList(Class<T> elementType) {
        this.elementType = elementType;
        numElements = 0;
        capacity = 1;
        elements = (T[]) Array.newInstance(elementType, capacity);
    }
    
    public void add(T object) {
        if (numElements == capacity) {
            increaseCapacity();
        }
        
        elements[numElements] = object;
        numElements += 1;
    }
    
    public void remove(int index) {
        for (int i = 0; i < numElements; i++) {
            if (i >= index) {
                // Removes the element by overwriting it
                elements[i] = elements[i + 1];
            }
        }
        numElements-=1;
    }
    
    public T get(int index) {
        return elements[index];
    }
    
    public int size() {
        return numElements;
    }
    
    private void increaseCapacity() {
       capacity *= CAPACITY_MULTIPLIER;
       T[] newArray = (T[]) Array.newInstance(elementType, capacity);
       
       // Copy all elements over to the new array take O(n) time
       System.arraycopy(elements, 0, newArray, 0, elements.length);
       elements = newArray;
    }
}
