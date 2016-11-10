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
    
    public void mergeSort(int[] array, int[] temp, int left, int right) {
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
}
