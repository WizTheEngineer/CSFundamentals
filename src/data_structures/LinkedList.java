/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

/**
 *
 * @author Wayne
 * @param <T>
 */
public class LinkedList<T> {
    
    public Node<T> head;
    
    public Node<T> append(T data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
            return head;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        
        return newNode;
    }
    
    public Node<T> append(Node<T> node) {
        if (head == null) {
            head = node;
            return head;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        return node;
    }
    
    public void prepend(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    public void deleteWithValue(T data) {
        if (head == null) return;
        
        // The head is the value to delete
        if (head.data == data) {
            head = head.next;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
            }
            current = current.next;
        }
    }
    
    public Node getHead() {
        return head;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void print() {
        if (isEmpty()) return;
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
