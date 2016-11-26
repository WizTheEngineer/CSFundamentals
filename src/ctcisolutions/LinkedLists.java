/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import data_structures.LinkedList;
import data_structures.Node;
import java.util.HashSet;

/**
 *
 * @author Wayne
 * Linked List solution for Cracking the Coding Interview.
 */
public class LinkedLists {
    
    // #1 Remove Duplicates
    public static void removeDuplicates(LinkedList<Integer> list) {
        if (list.isEmpty()) return;
        
        Node current = list.getHead();
        while (current != null) {
            removeDuplicates(current);
            current = current.next;
        }
    }
    
    public static void removeDuplicatesFast(Node<Integer> head) {
        HashSet<Integer> set = new HashSet();
        Node<Integer> previous = null;
        while (head != null) {
            if (set.contains(head.data)) {
                previous.next = head.next;
            } else {
                set.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }
    
    private static void removeDuplicates(Node<Integer> head) {
        Integer data = head.data;
        while (head != null && head.next != null) {
            if (head.next.data == data) {
                head.next = head.next.next;
            }
            head = head.next;
        }
    }
    
    // #2 Kth From Last
    public static Node<Integer> kthFromLastElement(LinkedList<Integer> list, int k) {
        if (list.isEmpty()) throw new IllegalArgumentException("Linked list "
                + "cannot be empty");
        Node<Integer> current = list.getHead();
        Node<Integer> runner = list.getHead();
        
        // Position the runner k positions away from the start
        for (int i = 1; i <= k; i++) {
            if (runner.next == null) {
                throw new IllegalArgumentException("The size of the linked list "
                        + "must be greater than k");
            }
            runner = runner.next;
        }
        
        // Move both the current node and the runner until the runner gets to the end of the list
        // Once the runner reaches the end of the list since it is k elements away from the current
        // node, the current node will be pointing to the kth from last element in the list
        while (runner.next != null) {
            current = current.next;
            runner = runner.next;
        }
        return current;
    }
}
