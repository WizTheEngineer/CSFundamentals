/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;
import java.util.ArrayList;

/**
 *
 * @author Wayne
 */
public class Heap {
    
    private static final HeapType DEFAULT_TYPE = HeapType.MAX;
    
    private final ArrayList<Integer> elements;
    private final HeapType type;
    private int size;
    
    public Heap() {
        elements = new java.util.ArrayList();
        type = DEFAULT_TYPE;
    }
    
    public Heap(HeapType type) {
        elements = new java.util.ArrayList();
        this.type = type;
    }
    
    public void add(int value) {
        elements.add(value);
        size++;
        
        // No need to sort because this is the first element added
        if (size == 1) return;
        
        int index = size - 1;
        int parentIndex = getParentIndex(index);
        int parentValue = elements.get(getParentIndex(index));
        
        while(childShouldBeSwappedWithParent(value, parentValue)) {
            swapChildWithParent(index, value, parentIndex, parentValue);
            index = parentIndex;
            parentIndex = getParentIndex(index);
            parentValue = elements.get(parentIndex);
        }
    }
    
    public int remove() {
        int index = 0;
        int value = elements.get(index);
        if (size == 1) {
            size--;
            elements.remove(index);
            return value;
        }
        
        // Replace value with furthest leaf node
        int replacementValue = elements.get(size - 1);
        elements.remove(size - 1);
        elements.remove(0);
        elements.add(0, replacementValue);
        size--;
        
        // Check if the replacement is in the right place
        while(elementShouldBeSwappedWithOneOfChildren(index)) {
            int leftIndex = getLeftChildIndex(index);
            int leftElement = elements.get(leftIndex);
            if (!hasTwoChildren(index)) {
                swapChildWithParent(leftIndex, leftElement, index, replacementValue);
                index = leftIndex;
            } else {
                // Since this node has two children determine which one it should swap with
                int rightIndex = getRightChildIndex(index);
                int rightElement = elements.get(rightIndex);
                
                if (type == HeapType.MIN) {
                    if (leftElement <= rightElement) {
                        // Swap them
                        swapChildWithParent(leftIndex, leftElement, index, replacementValue);
                        index = leftIndex;
                    } else {
                        // Swap them
                        swapChildWithParent(rightIndex, rightElement, index, replacementValue);
                        index = rightIndex;
                    }
                } else {
                    if (leftElement >= rightElement) {
                        // Swap them
                        swapChildWithParent(leftIndex, leftElement, index, replacementValue);
                        index = leftIndex;
                    } else {
                        // Swap them
                        swapChildWithParent(rightIndex, rightElement, index, replacementValue);
                        index = rightIndex;
                    }
                }
            }
        }
        return value;
    }
    
    private boolean elementShouldBeSwappedWithOneOfChildren(int index) {
        int value = elements.get(index);
        if (hasTwoChildren(index)) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            int leftElement = elements.get(leftIndex);
            int rightElement = elements.get(rightIndex);
                
            return childShouldBeSwappedWithParent(leftElement, value) ||
                       childShouldBeSwappedWithParent(rightElement, value);
        } else if (hasLeftChild(index)) {
            int leftIndex = getLeftChildIndex(index);
            int leftElement = elements.get(leftIndex);
            return childShouldBeSwappedWithParent(leftElement, value);
        }
        return false;
    }
    
    private boolean hasTwoChildren(int index) {
        return hasLeftChild(index) && hasRightChild(index);
    }
    
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    
    private boolean childShouldBeSwappedWithParent(int childValue, int parentValue) {
        if (type == HeapType.MIN) {
            return childValue < parentValue;
        }
        return childValue > parentValue;
    }
    
    private void swapChildWithParent(int childIndex, int childValue, int parentIndex, int parentValue) {
        elements.remove(childIndex);
        elements.add(childIndex, parentValue);
        elements.remove(parentIndex);
        elements.add(parentIndex, childValue);
    }
    
    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }
    
    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }
    
    private int getParentIndex(int childIndex) {
        if (childIndex > 0) {
            return (int) Math.floor((childIndex - 1) / 2);
        }
        return 0;
    }
    
    public void printValues() {
        for (int i = 0; i < size; i++) {
            System.out.print(" | " + elements.get(i) + " | ");
        }
    }
    
      public enum HeapType {
        MIN,
        MAX
    }
}
