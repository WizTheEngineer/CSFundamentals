/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctcisolutions;

import java.lang.reflect.Array;

/**
 *
 * @author Wayne Cracking the Coding Interview Stacks and Queues Solutions
 */
public class StacksAndQueues {

    // #1 3 Stacks with Array
    public static class ArrayThreeStack<T> {

        private int stackOneIndex = -3;
        private int stackTwoIndex = -2;
        private int stackThreeIndex = -1;
        private T[] elements;

        public ArrayThreeStack(Class<T> elementType, int capacity) {
            elements = (T[]) Array.newInstance(elementType, capacity);
        }

        public T top;

        public void push(int stackNumber, T element) {
            switch (stackNumber) {
                case 1:
                    stackOneIndex += 3;
                    elements[stackOneIndex] = element;
                    break;
                case 2:
                    stackTwoIndex += 3;
                    elements[stackTwoIndex] = element;
                    break;
                case 3:
                    stackThreeIndex += 3;
                    elements[stackThreeIndex] = element;
                    break;
                default:
                    throw new IllegalArgumentException("Stack number must be between 1 and 3");
            }
        }

        public T pop(int stackNumber) {
            T element = null;
            switch (stackNumber) {
                case 1:
                    element = elements[stackOneIndex];
                    elements[stackOneIndex] = null;
                    stackOneIndex -= 3;
                    break;
                case 2:
                    element = elements[stackTwoIndex];
                    elements[stackTwoIndex] = null;
                    stackTwoIndex -= 3;
                    break;
                case 3:
                    element = elements[stackThreeIndex];
                    elements[stackThreeIndex] = null;
                    stackThreeIndex -= 3;
                    break;
                default:
                    throw new IllegalArgumentException("Stack number must be between 1 and 3");
            }
            return element;
        }

        public T peek(int stackNumber) {
            T element = null;
            switch (stackNumber) {
                case 1:
                    element = elements[stackOneIndex];
                    break;
                case 2:
                    element = elements[stackTwoIndex];
                    break;
                case 3:
                    element = elements[stackThreeIndex];
                    break;
                default:
                    throw new IllegalArgumentException("Stack number must be betweeen 1 and 3");
            }
            return element;
        }

        public boolean isEmpty(int stackNumber) {
            switch (stackNumber) {
                case 1:
                    return stackOneIndex < 0;
                case 2:
                    return stackTwoIndex < 0;
                case 3:
                    return stackThreeIndex < 0;
                default:
                    throw new IllegalArgumentException("Stack number must be betweeen 1 and 3");
            }
        }
    }
}
