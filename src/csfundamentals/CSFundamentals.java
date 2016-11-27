/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.LinkedLists;
import data_structures.LinkedList;
import data_structures.Node;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList();
        Node<Integer> node1 = new Node(1);
        Node<Integer> node2 = new Node(2);
        Node<Integer> node3 = new Node(3);
        Node<Integer> node4 = new Node(4);
        
        list.append(node1);
        list.append(node2);
        
        boolean listHasLoop = LinkedLists.hasLoop(list);
        System.out.printf("List has loop %b\n", listHasLoop);
    }
}
