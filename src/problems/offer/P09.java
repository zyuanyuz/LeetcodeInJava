package problems.offer;

import java.util.Stack;

public class P09 {

    /**
     * 执行用时 : 357 ms , 在所有 Java 提交中击败了 17.31% 的用户 内存消耗 : 46.6 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    class CQueue {

        Stack<Integer> pushStack, cacheStack;

        public CQueue() {
            pushStack = new Stack<>();
            cacheStack = new Stack<>();
        }

        public void appendTail(int value) {
            while (!cacheStack.empty()) {
                pushStack.push(cacheStack.pop());
            }
            pushStack.push(value);
        }

        public int deleteHead() {
            if (pushStack.empty() && cacheStack.empty()) {
                return -1;
            }
            if (!cacheStack.empty()) {
                return cacheStack.pop();
            }
            while (pushStack.size() > 1) {
                cacheStack.push(pushStack.pop());
            }
            return pushStack.pop();
        }
    }
}