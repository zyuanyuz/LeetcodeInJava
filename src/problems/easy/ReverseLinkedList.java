package problems.easy;

/**
 * leetcode 206 ReverseLinkedList Easy
 * Reverse a singly linked list.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 * <p>
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    //Runtime: 25 ms, faster than 5.54% of Java online submissions for Reverse Linked List.
    //Memory Usage: 37.8 MB, less than 26.20% of Java online submissions for Reverse Linked List.
    public ListNode reverseListOne(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode result = new ListNode(Integer.MIN_VALUE), resultMoveNode = result;
        ListNode oriNodeHead = new ListNode(Integer.MIN_VALUE);
        oriNodeHead.next = head;
        ListNode curNode = oriNodeHead.next, preNode = oriNodeHead;
        while (curNode != null) {
            while (curNode.next != null) {
                curNode = curNode.next;
                preNode = preNode.next;
            }
            resultMoveNode.next = curNode;
            resultMoveNode = resultMoveNode.next;
            preNode.next = null;
            curNode = oriNodeHead.next;
            preNode = oriNodeHead;
        }
        return result.next;
    }

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
    //Memory Usage: 37.8 MB, less than 18.83% of Java online submissions for Reverse Linked List.
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultNode = null;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode tmpNode = curNode.next;
            curNode.next = resultNode;
            resultNode = curNode;
            curNode = tmpNode;
        }
        return resultNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
