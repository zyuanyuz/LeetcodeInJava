package problems.medium;

import java.util.HashSet;

//leetcode 142 LinkedListCycleII Medium

public class LinkedListCycleII {
    /**
     * 执行用时 : 7 ms , 在所有 Java 提交中击败了 28.63% 的用户 内存消耗 : 37.3 MB , 在所有 Java 提交中击败了
     * 5.03% 的用户
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode moveNode = head;
        while (moveNode != null) {
            if (!set.contains(moveNode)) {
                set.add(moveNode);
                moveNode = moveNode.next;
            } else {
                return moveNode;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}