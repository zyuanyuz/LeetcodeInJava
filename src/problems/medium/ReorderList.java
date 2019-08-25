package problems.medium;

import java.util.List;
import java.util.ArrayList;

/**
 * leetcode 143 ReorderList Medium
 */

public class ReorderList {
    //Runtime: 2 ms, faster than 38.26% of Java online submissions for Reorder List.
    //Memory Usage: 39.8 MB, less than 86.36% of Java online submissions for Reorder List.
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> nodeList = new ArrayList<>();
        ListNode move = head;
        for (; move != null; move = move.next) {
            nodeList.add(move);
        }
        int i = 0, j = nodeList.size() - 1;
        ListNode resultHead = new ListNode(0);
        move = resultHead;
        for (; i <= j;  i++,j--) {
            if (i == j) {
                move.next = nodeList.get(i);
                move.next.next = null;
                break;
            }
            move.next = nodeList.get(i);
            move = move.next;
            move.next = nodeList.get(j);
            move = move.next;
            move.next = null;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}