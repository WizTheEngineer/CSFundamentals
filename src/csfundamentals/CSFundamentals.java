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
        list.append(1);
        list.append(2);
        list.append(8);
        list.append(3);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(8);
        list.append(1);
        list.print();
        int k = 9;
        Node<Integer> kthFromLast = LinkedLists.kthFromLastElement(list, k);
        System.out.printf("%d from last element is %d\n", k, kthFromLast.data);
    }
}
