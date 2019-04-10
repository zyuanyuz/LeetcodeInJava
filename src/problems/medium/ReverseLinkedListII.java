package problems.medium;

/**
 * leetcode 92 ReverseLinkedListII Medium
 * Reverse a linked list from position m to n. Do it in one-pass.
 * <p>
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII {
    //Runtime: 1 ms, faster than 94.00% of Java online submissions for Reverse Linked List II.
    //Memory Usage: 35.7 MB, less than 92.53% of Java online submissions for Reverse Linked List II.
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n == 0) {
            return null;
        }
        if (m <= 0) m = 1;
        ListNode moveNode = head, linkNodeBack = null;
        ListNode resultNodeHead = new ListNode(Integer.MIN_VALUE), linkNodeHead = resultNodeHead;
        int count = 1;
        resultNodeHead.next = head;
        for (; count <= n; count++) {
            if (count == m - 1) {
                linkNodeHead = moveNode;
                moveNode = moveNode.next;
            } else if (count == m) {
                linkNodeBack = moveNode;
                linkNodeHead.next = moveNode;
                moveNode = moveNode.next;
            } else if (count > m) {
                ListNode tmp = moveNode;
                moveNode = moveNode.next;
                tmp.next = linkNodeHead.next;
                linkNodeHead.next = tmp;
            } else {
                moveNode = moveNode.next;
            }
        }
        if (linkNodeBack != null) linkNodeBack.next = moveNode;
        return resultNodeHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
