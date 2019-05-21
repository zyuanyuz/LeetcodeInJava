package problems.medium;

/**
 * leetcode 148
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode result = listQuickSort(head);
        return result;
    }

    ListNode listQuickSort(ListNode node) {
        ListNode pivotNode = node;
        ListNode i = node, j = node, tmp;
        while (j.next != null) {
            if (j.next.val < pivotNode.val) {
                tmp = j.next;
                j.next = j.next.next;
                tmp.next = i.next;
                i.next = tmp;
                i = tmp;
                if (i == j)
                    j = j.next;
            } else {
                j = j.next;
            }
        }
        ListNode leftList = null, rightList = null, linkNode = null;
        if (i != node) { // left is not null
            leftList = listQuickSort(node.next);
        }
        if (i != j) {// rightList is not null
            rightList = listQuickSort(i.next);
        }
        if (leftList != null) {
            linkNode = leftList;
            while (linkNode.next != null) {
                linkNode = linkNode.next;
            }
            // too much case!ugly code!
        }
        return null;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}