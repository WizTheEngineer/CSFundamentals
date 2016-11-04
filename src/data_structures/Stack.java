/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

/**
 *
 * @author Wayne
 * LIFO Data Structure
 */
public class Stack<T> {
    Node<T> top;
    
    boolean isEmpty() {
        return top == null;
    }
    
    public void push(T data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }
    
    public T pop() {
        T value = top.data;
        top = top.next;
        return value;
    }
    
    public T peek() {
        return top.data;
    }
}
