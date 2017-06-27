/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data_structures;

import java.util.HashSet;

/**
 *
 * @author Wayne
 */
public class Graph {
    
    private final int capacity;
    private final GraphNode[] children;
    private int currentIndex;
    
    public Graph(int capacity) {
        children = new GraphNode[capacity];
        this.capacity = capacity;
        this.currentIndex = 0;
    }
    
    public void addNode(GraphNode node) {
        if (currentIndex == capacity) throw new IllegalStateException("Graph has reached capacity");
        children[currentIndex] = node;
        currentIndex++;
    }
    
    public void dfs(GraphNode root) {
        GraphNode start = findNode(root);
        if (start == null) {
            return;
        }
        
        dfs(start, new HashSet());
    }
    
    private void dfs(GraphNode root, HashSet<GraphNode> visited) {
        // Visit the root
        visit(root, visited);
        
        // Visit the adjacent nodes if there are any
        LinkedList<GraphNode> adjacencyList = root.adjacencyList;
        if (adjacencyList.isEmpty()) {
            return;
        }
        
        LinkedListNode<GraphNode> current = adjacencyList.getHead();
        while (current != null) {
            GraphNode node = current.data;
            if (!visited.contains(node)) {
                dfs(node, visited);
            }
            current = current.next;
        }
    }
    
    public void bfs(GraphNode root) {
        GraphNode start = findNode(root);
        if (start == null) {
            return;
        }
        
        Queue<GraphNode> queue = new Queue();
        HashSet<GraphNode> visited = new HashSet();
        queue.enqueue(root);
        
        while (!queue.isEmpty()) {
            GraphNode node = queue.dequeue(); // Remove from the front of the queue
            visit(node, visited);
            LinkedListNode<GraphNode> current = node.adjacencyList.getHead();
            while (current != null) {
                if (!visited.contains(current.data)) {
                    visited.add(current.data);
                    queue.enqueue(current.data);
                }
                current = current.next;
            }
        }
    }
    
    // Find the node O(n)
    private GraphNode findNode(GraphNode node) {
        for (int i = 0; i < capacity; i++) {
            if (children[i] == node) {
                return children[i];
            }
        }
        return null;
    }
    
    private void visit(GraphNode node, HashSet<GraphNode> visited) {
        System.out.println(node.data);
        visited.add(node);
    }
    
    public static class GraphNode<T> {
        public T data;
        public LinkedList<GraphNode> adjacencyList;
        
        public GraphNode(T data) {
            this.data = data;
            this.adjacencyList = new LinkedList();
        }
        
        public LinkedList<GraphNode> getConnections() {
            return adjacencyList;
        }
        
        public void addConnection(GraphNode node) {
            adjacencyList.append(node);
        }
    }
}
