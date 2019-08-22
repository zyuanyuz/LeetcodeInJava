package problems.easy;

/**
 * leetcode 141 LinkedListCycle Easy
 */
public class LinkedListCycle {
    //Runtime: 169 ms, faster than 7.47% of Java online submissions for Linked List Cycle.
    //Memory Usage: 37.5 MB, less than 93.57% of Java online submissions for Linked List Cycle.
    public boolean hasCycle(ListNode head) {
        ListNode move = head;
        ListNode front = head;
        int frontLen = 0;
        while (front != null) {
            front = front.next;
            frontLen++;
            for (int i = 0; i < frontLen; i++) {
                if (move == front) {
                    return true;
                }
                move = move.next;
            }
            move = head;
        }
        return false;
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