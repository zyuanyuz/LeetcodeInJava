package problems.medium;

/**
 * leetcode 86 PartitionList Medium
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
    //Memory Usage: 36.8 MB, less than 67.44% of Java online submissions for Partition List.
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode resultHead = new ListNode(Integer.MIN_VALUE), linkSmallNode = resultHead;
        ListNode biggerNode = new ListNode(Integer.MIN_VALUE), linkBigNode = biggerNode;
        while (head != null) {
            if (head.val < x) {
                linkSmallNode.next = head;
                head = head.next;
                linkSmallNode = linkSmallNode.next;
                linkSmallNode.next = null;
            } else {
                linkBigNode.next = head;
                head = head.next;
                linkBigNode = linkBigNode.next;
                linkBigNode.next = null;
            }
        }
        linkSmallNode.next = biggerNode.next;
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
