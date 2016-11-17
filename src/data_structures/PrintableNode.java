/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

/**
 *
 * @author Wayne
 */
public interface PrintableNode {

    /**
     * Get left child
     * @return 
     */
    PrintableNode getLeft();

    /**
     * Get right child
     * @return 
     */
    PrintableNode getRight();

    /**
     * Get text to be printed
     * @return 
     */
    String getText();
}
