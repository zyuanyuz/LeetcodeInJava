package problems.medium;

/**
 * leetcode 82 RemoveDuplicatesfromSortedListII Medium
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 * Example 2:
 * <p>
 * Input: 1->1->1->2->3
 * Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII {
    //Runtime: 1 ms, faster than 36.98% of Java online submissions for Remove Duplicates from Sorted List II.
    //Memory Usage: 37.5 MB, less than 51.76% of Java online submissions for Remove Duplicates from Sorted List II.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = new ListNode(Integer.MIN_VALUE);
        ListNode linkNode = resultHead, moveNode = head, testNode;
        while (moveNode != null) {
            testNode = moveNode.next;
            if (testNode != null && testNode.val == moveNode.val) {
                while (moveNode != null && moveNode.val == testNode.val) {//find a Node with diff val
                    moveNode = moveNode.next;
                }

            } else {
                linkNode.next = moveNode;
                linkNode = linkNode.next;
                moveNode = moveNode.next;
            }
        }
        linkNode.next = null;
        return resultHead.next;
    }

    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        ListNode result = deleteDuplicates(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
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
