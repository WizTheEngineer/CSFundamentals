/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csfundamentals;

import ctcisolutions.TreesAndGraphs;
import data_structures.AVLTree;
import data_structures.BinarySearchTree;
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
        GraphNode<Integer> three = new GraphNode(3);
        GraphNode<Integer> four = new GraphNode(4);
        GraphNode<Integer> five = new GraphNode(5);
        GraphNode<Integer> six = new GraphNode(6);
        GraphNode<Integer> seven = new GraphNode(7);
        
        three.addConnection(four);
        four.addConnection(seven);
        four.addConnection(three);
        five.addConnection(four);
        five.addConnection(seven);
        seven.addConnection(four);
        seven.addConnection(six);
        
        Graph graph = new Graph(5);
        graph.addNode(three);
        graph.addNode(four);
        graph.addNode(five);
        graph.addNode(six);
        graph.addNode(seven);
        
        boolean hasPath = TreesAndGraphs.hasRouteBetweenNodes(six, five);
        System.out.printf("Has path? %b\n", hasPath);
        
        int[] sortedArray = {9, 10, 11, 12, 13, 14, 20, 25, 40, 50, 60, 70};
        BinarySearchTree<Integer> minTree = TreesAndGraphs.buildMinimalTree(sortedArray);
        minTree.printPretty();
    }
}
