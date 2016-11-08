/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.Arrays;

/**
 *
 * @author Wayne
 * Implementation of a heap where you can specify the type using the constructor.
 */
public class Heap {
    private static Type DEFAULT_TYPE = Type.MIN;
    private int capacity = 10;
    private int size = 0;
    private Type type;
    
    int[] items = new int[capacity];
    
    public Heap() {
        type = DEFAULT_TYPE;
    }
    
    public Heap(Type type) {
        this.type = type;
    }
    
    public int peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }
    
    public int poll() {
        if (size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }
    
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }
    
    private void heapifyDown() {
        int index = 0;
        
        while(shouldSwapDown(index)) {
            int swapDownIndex = getSwapDownIndex(index);
            swap(index, swapDownIndex);
            index = swapDownIndex;
        }
    }
    
    private boolean shouldSwapDown(int index) {
        int item = items[index];
        
        if (hasLeftChild(index)) {
            int leftChild = leftChild(index);
            
            if (hasRightChild(index)) {
                int rightChild = rightChild(index);
                
                if (type == Type.MIN) {
                    return Math.min(leftChild, rightChild) < item;
                } else  {
                    return Math.max(leftChild, rightChild) > item;
                }
            }
            
            if (type == Type.MIN) {
                return leftChild < item;
            } else {
                return leftChild > item;
            }
        }
        return false;
    }
    
    private int getSwapDownIndex(int index) {
        int leftChild = leftChild(index);
            
        if (hasRightChild(index)) {
            int rightChild = rightChild(index);
            if (type == Type.MIN) {
                if (rightChild < leftChild) {
                    return getRightChildIndex(index);
                }
            } else  {
                if (rightChild > leftChild) {
                    return getRightChildIndex(index);
                }
            }
        }
        return getLeftChildIndex(index);
    }
    
    private void heapifyUp() {
        int index = size - 1;
        
        while (shouldSwapWithParent(index)) {
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }
    
    private boolean shouldSwapWithParent(int index) {
        int item = items[index];
        if (hasParent(index)) {
            int parent = parent(index);
            
            if (type == Type.MIN) {
                return item < parent;
            } else {
                return item > parent;
            }
        }
        
        return false;
    }
    
    private int getLeftChildIndex(int parentIndex) { 
        return 2 * parentIndex + 1;
    }
    
    private int getRightChildIndex(int parentIndex) { 
        return 2 * parentIndex + 2;
    }
    
    private int getParentIndex(int childIndex) { 
        return (childIndex - 1) / 2; 
    }
    
    private boolean hasLeftChild(int index) { 
        return getLeftChildIndex(index) < size; 
    }
    
    private boolean hasRightChild(int index) { 
        return getRightChildIndex(index) < size; 
    }
    
    private boolean hasParent(int index) { 
        return getParentIndex(index) >= 0; 
    }
    
    private int leftChild(int index) { 
        return items[getLeftChildIndex(index)];
    }
    
    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }
    
    private int parent(int index) {
        return items[getParentIndex(index)];
    }
    
    private void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }
    
    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }
    
    public void printValues() {
        for (int i = 0; i < size; i++) {
            int item = items[i];
            System.out.print(" | " + item + " | ");
        }
    }
    
    public static enum Type {
        MIN,
        MAX
    }
}
