/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import data_structures.Heap;
import data_structures.Heap.Type;

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
    
}
