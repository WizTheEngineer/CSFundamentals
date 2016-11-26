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
public class Node<T> {
    public T data;
    public Node<T> next;
    
    public Node(T value) {
        this.data = value;
    }
}
