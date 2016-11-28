/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import data_structures.Graph;
import data_structures.Graph.GraphNode;

/**
 *
 * @author Wayne
 */
public class CSFundamentals {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GraphNode<Integer> one = new GraphNode(1);
        GraphNode<Integer> three = new GraphNode(3);
        GraphNode<Integer> four = new GraphNode(4);
        GraphNode<Integer> six = new GraphNode(6);
        GraphNode<Integer> seven = new GraphNode(7);
        GraphNode<Integer> eight = new GraphNode(8);
        GraphNode<Integer> nine = new GraphNode(9);
        GraphNode<Character> c = new GraphNode('c');
        
        one.addConnection(three);
        three.addConnection(one);
        one.addConnection(eight);
        eight.addConnection(one);
        three.addConnection(seven);
        seven.addConnection(three);
        three.addConnection(four);
        four.addConnection(three);
        seven.addConnection(four);
        four.addConnection(seven);
        four.addConnection(six);
        six.addConnection(four);
        eight.addConnection(nine);
        nine.addConnection(eight);
        
        Graph graph = new Graph(15);
        graph.addNode(one);
        graph.addNode(three);
        graph.addNode(four);
        graph.addNode(six);
        graph.addNode(seven);
        graph.addNode(eight);
        graph.addNode(c);
        
        graph.bfs(one);
    }
}
