/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures.interfaces;

/**
 *
 * @author Wayne
 * Abstract data type for a balanced binary search tree.
 */
public interface BalancedBST {
    
    /***
     * Insert data into the binary tree.
     * @param data 
     */
    void insert(Integer data);
    
    /***
     * Remove data from the binary tree.
     * @param data 
     */
    void delete(Integer data);
    
    /***
     * Get the minimum value in the binary tree.
     * @return 
     */
    Integer getMin();
    
    /***
     * Get the maximum value in the binary tree.
     * @return 
     */
    Integer getMax();
    
    /***
     * Get the value after a given value in the binary tree.
     * @param data
     * @return 
     */
    Integer getSuccessor(Integer data);
    
    /***
     * Get the value before a given value in the binary tree.
     * @param data
     * @return 
     */
    Integer getPredecessor(Integer data);
    
    /***
     * Prints the values in the tree in order.
     */
    void printInorder();
}
