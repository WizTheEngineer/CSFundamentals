/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import data_structures.LinkedList;
import data_structures.Node;
import data_structures.Stack;
import java.util.HashSet;

/**
 *
 * @author Wayne Linked List solution for Cracking the Coding Interview.
 */
public class LinkedLists {

    // #1 Remove Duplicates
    public static void removeDuplicates(LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return;
        }

        Node current = list.getHead();
        while (current != null) {
            removeDuplicates(current);
            current = current.next;
        }
    }

    public static void removeDuplicatesFast(Node<Integer> head) {
        HashSet<Integer> set = new HashSet();
        Node<Integer> previous = null;
        while (head != null) {
            if (set.contains(head.data)) {
                previous.next = head.next;
            } else {
                set.add(head.data);
                previous = head;
            }
            head = head.next;
        }
    }

    private static void removeDuplicates(Node<Integer> head) {
        int data = head.data;
        while (head != null && head.next != null) {
            if (head.next.data == data) {
                head.next = head.next.next;
            }
            head = head.next;
        }
    }

    // #2 Kth From Last
    public static Node<Integer> kthFromLastElement(LinkedList<Integer> list, int k) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Linked list "
                    + "cannot be empty");
        }
        Node<Integer> current = list.getHead();
        Node<Integer> runner = list.getHead();

        // Position the runner k positions away from the start
        for (int i = 1; i <= k; i++) {
            if (runner.next == null) {
                throw new IllegalArgumentException("The size of the linked list "
                        + "must be greater than k");
            }
            runner = runner.next;
        }

        // Move both the current node and the runner until the runner gets to the end of the list
        // Once the runner reaches the end of the list since it is k elements away from the current
        // node, the current node will be pointing to the kth from last element in the list
        while (runner.next != null) {
            current = current.next;
            runner = runner.next;
        }
        return current;
    }

    // #3 Delete Middle Node
    public boolean deleteNode(Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        Node next = node.next;
        node.data = next.data;
        node.next = next.next;
        return true;
    }

    // #4 Partition
    public static void partitionList(LinkedList<Integer> list, int partitionValue) {
        if (list.isEmpty()) {
            return;
        }
        list.head = partitionMoreOptimal(list.getHead(), partitionValue);
    }

    private static void partition(Node<Integer> node, int partitionValue) {
        if (node == null) return;
        if (node.data >= partitionValue) {
            // Find the furthest node less than the partition
            Node<Integer> shiftNode = node;
            Node<Integer> current = node.next;
            while (current != null) {
                if (current.data < partitionValue) {
                    shiftNode = current;
                }
                current = current.next;
            }
            
            if (shiftNode != node) {
                int data = node.data;
                node.data = shiftNode.data;
                shiftNode.data = data;
            }
        }
        partition(node.next, partitionValue);
    }
    
    private static Node<Integer> partitionMoreOptimal(Node<Integer> node, int partitionValue) {
        Node<Integer> head = node;
        Node<Integer> tail = node;
        
        while (node != null) {
            Node<Integer> next = node.next;
            if (node.data < partitionValue) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
    
    // #5 Sum Lists
    // This assumes that each list contains elements of a single digit no validation 
    // will be done with this algorithm
    public static LinkedList<Integer> sumListReverseOrder(LinkedList<Integer> top, LinkedList<Integer> bottom) {
        if (top.isEmpty() || bottom.isEmpty()) throw new IllegalArgumentException();
        Node<Integer> topDigit = top.getHead();
        Node<Integer> bottomDigit = bottom.getHead();
        LinkedList<Integer> output = new LinkedList();
        
        boolean carryOne = false;
        while (topDigit != null && bottomDigit != null) {
            int sum = topDigit.data + bottomDigit.data;
            
            if (carryOne) {
                sum += 1;
            }
            
            if (sum >= 10) {
                carryOne = true;
                sum = sum % 10;
            } else {
                carryOne = false;
            }
            output.append(sum);
            
            topDigit = topDigit.next;
            bottomDigit = bottomDigit.next;
        }
        
        // Only one of these will run if the top and bottom digit have different lengths
        while (topDigit != null) {
            int digit = topDigit.data;
            
            if (carryOne) {
                digit += 1;
            }
            
            if (digit >= 10) {
                carryOne = true;
                digit = 0;
            } else {
                carryOne = false;
            }
            output.append(digit);
            topDigit = topDigit.next;
        }
        
        while (bottomDigit != null) {
            int digit = bottomDigit.data;
            
            if (carryOne) {
                digit += 1;
            }
            
            if (digit >= 10) {
                carryOne = true;
                digit = 0;
            } else {
                carryOne = false;
            }
            output.append(digit);
            bottomDigit = bottomDigit.next;
        }
        
        if (carryOne) {
            output.append(1);
        }
        return output;
    }
    
    // # 6 Is Palindrome?
    public static boolean isPalindrome(LinkedList<Character> list) {
        if (list.isEmpty()) return true;
        
        // Calculate the length of the list (Note: This could be improved if the list keeps track of the length)
        int length = 0;
        Node<Character> current = list.getHead();
        while (current != null) {
            current = current.next;
            length++;
        }
        
        // Single element is always a palindrome
        if (length == 1) return true;
        
        // Check if odd or even
        boolean isEvenLength = length % 2 == 0;
        int firstEnd = length / 2;
        
        // If the length is odd skip the middle element since it doesn't matter
        int secondStart = isEvenLength ? firstEnd + 1 : firstEnd + 2;
        
        // This stack will be used to solve the problem
        Stack<Character> charStack = new Stack();
        
        // Start at the beginning
        int counter = 1;
        current = list.getHead();
        while (current != null) {
            if (counter <= firstEnd) {
                // Push the first half to a stack
                charStack.push(current.data);
            } else if (counter >= secondStart) {
                // Pop characters from stack and compare
                char c = charStack.pop();
                if (c != current.data) {
                    return false;
                }
            }
            current = current.next;
            counter++;
        }
        
        return true;
    }
    
    // #7 Loop Detection
    public static boolean hasLoop(LinkedList list) {
        if (list.isEmpty()) return false;
        Node slow = list.getHead();
        Node fast = list.getHead();
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) {
                return true;
            }
        }
        
        return false;
    }
}
