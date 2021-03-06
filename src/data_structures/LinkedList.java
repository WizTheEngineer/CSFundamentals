/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.List;

/**
 *
 * @author Wayne
 * @param <T>
 */
public class LinkedList<T> {
    
    public LinkedListNode<T> head;
    
    public LinkedListNode<T> append(T data) {
        LinkedListNode newNode = new LinkedListNode(data);
        
        if (head == null) {
            head = newNode;
            return head;
        }
        
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        
        return newNode;
    }
    
    public LinkedListNode<T> append(LinkedListNode<T> node) {
        if (head == null) {
            head = node;
            return head;
        }
        
        LinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return node;
    }
    
    public void prepend(T data) {
        LinkedListNode newNode = new LinkedListNode(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void deleteWithValue(T data) {
        if (head == null) return;
        
        // The head is the value to delete
        if (head.data == data) {
            head = head.next;
        }
        
        LinkedListNode current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }
    
    public LinkedListNode<T> getHead() {
        return head;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void addAll(List<T> collection) {
        for (T t : collection) {
            append(t);
        }
    }
    
    public void print() {
        if (isEmpty()) return;
        LinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
