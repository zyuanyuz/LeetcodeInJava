package problems.hard;

import java.util.Stack;

//leetcode 32 LongestValidParentheses Hard
public class LongestValidParentheses {

    /**
     * 执行用时 : 15 ms , 在所有 java 提交中击败了 11.11% 的用户 内存消耗 : 38 MB , 在所有 java 提交中击败了
     * 78.71% 的用户
     * 
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<Character>();
        Stack<Integer> lastIndex = new Stack<Integer>();
        lastIndex.push(-1);
        int maxResult = 0;
        int headIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                lastIndex.push(i);
            } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
                stack.pop();
                lastIndex.pop();
                headIndex = i;
                if (headIndex - lastIndex.peek() > maxResult) {
                    maxResult = headIndex - lastIndex.peek();
                }
            } else {
                lastIndex.push(i);
            }
        }
        return maxResult;
    }

    public static void main(String[] args) {
        LongestValidParentheses l = new LongestValidParentheses();
        System.out.println(l.longestValidParentheses("(())()"));
    }
    // (())()((((())(())()()(()((()()(()))))(()))
    // )(
    // )()())
    // ())()())))
}