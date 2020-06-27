package problems.easy;

import java.util.Stack;

/**
 * leetcode 155 MinStack
 */
public class MinStack {

    /**
     * 执行用时： 10 ms , 在所有 Java 提交中击败了 19.54% 的用户 内存消耗： 41.9 MB , 在所有 Java 提交中击败了
     * 13.25% 的用户
     */
    Stack<Integer> stack;

    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        int min = minStack.isEmpty() ? x : minStack.peek();
        min = x > min ? min : x;
        stack.push(x);
        minStack.push(min);
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}