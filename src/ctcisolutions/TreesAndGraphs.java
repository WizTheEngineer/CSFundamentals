/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import data_structures.BST;
import data_structures.BST.BinaryNode;
import data_structures.Graph.GraphNode;
import data_structures.LinkedList;
import data_structures.LinkedListNode;
import data_structures.Queue;
import data_structures.Stack;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

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
            LinkedListNode<GraphNode> current = node.adjacencyList.getHead();
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
    public static BST<Integer> buildMinimalTree(int[] sortedArray) {
        BST<Integer> tree = new BST();
        buildMinimalTree(tree, sortedArray, 0, sortedArray.length - 1);
        return tree;
    }

    private static void buildMinimalTree(BST<Integer> tree, int[] sortedArray, int start, int end) {
        if (start > end) {
            return;
        }

        // Find the middle element and insert it into the tree
        int middleIndex = (start + end) / 2;
        tree.insert(sortedArray[middleIndex]);
        buildMinimalTree(tree, sortedArray, start, middleIndex - 1);
        buildMinimalTree(tree, sortedArray, middleIndex + 1, end);
    }

    // #3 List of Depths
    public static List<LinkedList<BinaryNode>> listOfDepths(BST tree) {
        if (tree.isEmpty()) throw new IllegalArgumentException("Tree cannot be empty");

        // Maps
        HashMap<Integer, List<BinaryNode>> levelMap = new HashMap();

        // Build the level map
        buildLevelMap(tree.getRoot(), levelMap, 1);

        List<LinkedList<BinaryNode>> listOfDepths = new ArrayList();

        for (int key : levelMap.keySet()) {
            LinkedList<BinaryNode> depthList = new LinkedList();
            List<BinaryNode> elements = levelMap.get(key);
            for (BinaryNode node : elements) {
                depthList.append(node);
            }
            listOfDepths.add(depthList);
        }

        return listOfDepths;
    }

    // Builds a map of nodes that are mapped to the "level" or "depth" inside of a binary tree.
    private static void buildLevelMap(BinaryNode root, HashMap<Integer, List<BinaryNode>> levelMap, int level) {
        if (root == null) return;
        if (!levelMap.containsKey(level)) {
            levelMap.put(level, new ArrayList<>());
        }
        levelMap.get(level).add(root);
        buildLevelMap(root.left, levelMap, level+1);
        buildLevelMap(root.right, levelMap, level+1);
    }

    // Bonus: Reconstruct binary tree from preorder and inorder traversals
    public static SpecialNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static SpecialNode construct(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }
        
        // The root is the first node in the preorder
        SpecialNode root = new SpecialNode(preorder[preStart]);
        int rootValue = root.data;
        
        // Find the index of the root in the inorder traversal
        int rootInorderPos = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            int value = inorder[i];
            if (value == rootValue) {
                rootInorderPos = i;
            }
        }
        
        root.left = construct(preorder, preStart + 1, preStart + rootInorderPos, inorder, inStart, rootInorderPos - 1);
        root.right = construct(preorder, preStart + rootInorderPos + 1, preEnd, inorder, rootInorderPos + 1, inEnd);
        return root;
    }

    public static class SpecialNode {
        public int data;
        public SpecialNode left, right;

        public SpecialNode(int data) {
            this.data = data;
        }

        public void printInorder() {
            printInorder(this);
        }

        private void printInorder(SpecialNode node) {
            if (node == null) return;
            printInorder(node.left);
            System.out.printf("%d ", node.data);
            printInorder(node.right);
        }
    }
    
    public static class Node {
        public int value;
        public Node left;
        public Node right;
    }
}
