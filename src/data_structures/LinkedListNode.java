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
public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;
    
    public LinkedListNode(T value) {
        this.data = value;
    }
}
