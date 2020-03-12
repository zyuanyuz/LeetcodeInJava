package problems.offer;

import java.util.Stack;

public class P31 {

    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 38.80% 的用户 内存消耗 : 41.6 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, index = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.empty() && stack.peek() == popped[index]) {
                index++;
                stack.pop();
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        P31 p = new P31();
        System.out.println(p.validateStackSequences(new int[] { 1, 2, 3, 4, 5 }, new int[] { 4, 2, 5, 3, 1 }));
    }
}