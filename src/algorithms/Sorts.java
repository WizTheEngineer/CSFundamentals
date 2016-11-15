/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author Wayne
 * Class containing various sorting algorithms.
 */
public class Sorts {
    
    /**
     * Merge sort algorithm.
     * @param array
     * @return 
     */
    public int[] mergeSort(int[] array) {
        mergeSort(array, new int[array.length], 0, array.length - 1);
        return array;
    }
    
    private void mergeSort(int[] array, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        
        // Prevents integer overflow by not using (left + right) / 2 because left + right can cause an integer overflow
        int mid = left + ((right - left) / 2);
        mergeSort(array, temp, left, mid);
        mergeSort(array, temp, mid + 1, right);
        mergeHalves(array, temp, left, right);
    }
    
    private void mergeHalves(int[] array, int[] temp, int leftStart, int rightEnd) {
        int mid = leftStart + ((rightEnd - leftStart) / 2);
        int leftEnd = mid;
        
        // The right half start one past the middle
        int rightStart = mid + 1;
        int size = rightEnd - leftStart + 1;
        
        int leftPointer = leftStart;
        int rightPointer = rightStart;
        int index = leftStart;
        
        while (leftPointer <= leftEnd && rightPointer <= rightEnd) {
            
            // Copy elements into temp array in ascending order
            if (array[leftPointer] <= array[rightPointer]) {
                temp[index++] = array[leftPointer++];
            } else {
                temp[index++] = array[rightPointer++];
            }
        }
        
        // Ensure the rest of the elements are added, only one of these will be called
        while (leftPointer <= leftEnd) {
            temp[index++] = array[leftPointer++];
        }
        
        while (rightPointer <= rightEnd) {
            temp[index++] = array[rightPointer++];
        }
        
        // Copy the elements from the temp array into the actual array
        System.arraycopy(temp, leftStart, array, leftStart, size);
    }
    
    /**
     * Quick sort algorithm
     * @param array 
     */
    public void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }
    
    private void quickSort(int[] array, int start, int end) {
        if (start >= end) return;
        int pivotIndex = partitionArray(array, start, end);
        quickSort(array, start, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, end);
    }
    
    /**
     * Partitions the array for quick sort and returns the index of the pivot.
     * @param array
     * @param start
     * @param end
     * @return 
     */
    private int partitionArray(int[] array, int start, int end) {
        // Select the right most element as the pivot
        int pivot = array[end];
        int pivotIndex = start;
        
        // Loop all the way through to one element before the pivot at the end
        for (int i = start; i < end; i++) {
            if (array[i] <= pivot) {
                swapElements(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        
        // Swap the element at the partion index with the pivot at the end
        swapElements(array, pivotIndex, end);
        
        return pivotIndex;
    }
    
    private void swapElements(int[] array, int indexOne, int indexTwo) {
        int temp = array[indexOne];
        array[indexOne] = array[indexTwo];
        array[indexTwo] = temp;
    }
}
