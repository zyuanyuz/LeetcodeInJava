package problems.easy;

/**
 * leetcode 83 RemoveDuplicatesfromSortedList Easy
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * Example 1:
 * <p>
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 * <p>
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class RemoveDuplicatesfromSortedList {
    //Runtime: 1 ms, faster than 21.23% of Java online submissions for Remove Duplicates from Sorted List.
    //Memory Usage: 37.8 MB, less than 25.62% of Java online submissions for Remove Duplicates from Sorted List.
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = new ListNode(Integer.MIN_VALUE);
        resultHead.next = head;
        ListNode moveNode = head, linkNode = head;
        int lastNum = head.val;
        while (moveNode != null && moveNode.next != null) {
            moveNode = moveNode.next;
            if (moveNode.val == lastNum) {
                while (moveNode != null && moveNode.val == lastNum) {
                    moveNode = moveNode.next;
                }
            }
            if (moveNode != null) {
                lastNum = moveNode.val;
                linkNode.next = moveNode;
                linkNode = linkNode.next;
            }
        }
        linkNode.next = null;
        return resultHead.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
