/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

/**
 *
 * @author Wayne
 * FIFO data structure.
 */
public class Queue<T> {
    
    private Node<T> head;
    private Node<T> tail;
    
    public boolean isEmpty() {
        return head == null;
    }
    
    public void enqueue(T data) {
        Node node = new Node(data);
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
    }
    
    public T dequeue() {        
        T value = head.data;
        head = head.next;
        return value;
    }
    
    public T peek() {
        return head.data;
    }
}
