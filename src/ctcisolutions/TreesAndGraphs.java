/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import data_structures.AVLTree;
import data_structures.BinarySearchTree;
import data_structures.Graph.GraphNode;
import data_structures.Node;
import data_structures.Queue;
import java.util.HashSet;

/**
 *
 * @author Wayne
 */
public class TreesAndGraphs {
    
    // #1 Has Route Between Nodes
    public static boolean hasRouteBetweenNodes(GraphNode one, GraphNode two) {
        return bfsForPath(one, two) || bfsForPath(two, one);
    }
    
    private static boolean bfsForPath(GraphNode root, GraphNode destination) {
        Queue<GraphNode> queue = new Queue();
        HashSet<GraphNode> visited = new HashSet();
        queue.enqueue(root);
        
        while (!queue.isEmpty()) {
            GraphNode node = queue.dequeue(); // Remove from the front of the queue
            if (node == destination) return true;
            visited.add(node);
            Node<GraphNode> current = node.adjacencyList.getHead();
            while (current != null) {
                if (!visited.contains(current.data)) {
                    visited.add(current.data);
                    queue.enqueue(current.data);
                }
                current = current.next;
            }
        }
        return false;
    }
    
    // #2 Binary Search Tree Minimal Height Sorted Array
    public static BinarySearchTree<Integer> buildMinimalTree(int[] sortedArray) {
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        buildMinimalTree(tree, sortedArray, 0, sortedArray.length - 1);
        return tree;
    }
    
    private static void buildMinimalTree(BinarySearchTree<Integer> tree, int[] sortedArray, int start, int end) {
        if (start > end) {
            return;
        }
        
        // Find the middle element and insert it into the tree
        int middleIndex = (start + end) / 2;
        tree.insert(sortedArray[middleIndex]);
        buildMinimalTree(tree, sortedArray, start, middleIndex - 1);
        buildMinimalTree(tree, sortedArray, middleIndex + 1, end);
    }
}
