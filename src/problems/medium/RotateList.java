package problems.medium;

/**
 * leecode 61 Medium
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 * Example 2:
 * <p>
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 */
public class RotateList {
    //Runtime: 6 ms, faster than 100.00% of Java online submissions for Rotate List.
    //Memory Usage: 38.2 MB, less than 12.81% of Java online submissions for Rotate List.
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode backNode = head, forwardNode = head;
        int length = 1;
        while (forwardNode.next != null) {
            forwardNode = forwardNode.next;
            length++;
        }
        forwardNode.next = head;   //set a Node circle
        forwardNode = head;
        for (int i = 0; i < k % length; i++) {
            forwardNode = forwardNode.next;
        }
        while (forwardNode.next != head) {
            forwardNode = forwardNode.next;
            backNode = backNode.next;
        }
        forwardNode = backNode.next;
        backNode.next = null;
        return forwardNode;
    }

    public void test() {
        //tested on leetcode.com
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
