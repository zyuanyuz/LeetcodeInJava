package problems.medium;

import java.util.Stack;

/**
 * leetcode 150 EvaluateReversePolishNotation Medium
 * 
 */

public class EvaluateReversePolishNotation {
    //Runtime: 7 ms, faster than 28.31% of Java online submissions for Evaluate Reverse Polish Notation.
    //Memory Usage: 36.8 MB, less than 65.07% of Java online submissions for Evaluate Reverse Polish Notation.
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        if (tokens.length == 0)
            return 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b + a));
            } else if (tokens[i].equals("-")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b - a));
            } else if (tokens[i].equals("*")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b * a));
            } else if (tokens[i].equals("/")) {
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(b / a));
            } else {
                stack.push(tokens[i]);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}