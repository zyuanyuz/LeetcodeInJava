package problems.medium;

/**
 * leetcode 148 SortList Medium
 * 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    //Runtime: 333 ms, faster than 8.46% of Java online submissions for Sort List.
    //Memory Usage: 40.6 MB, less than 79.22% of Java online submissions for Sort List.
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int len = 0;
        ListNode moveNode = head;
        while (moveNode != null) { // count the length of the list
            len++;
            moveNode = moveNode.next;
        }
        listQuickSort(head, len);
        return head;
    }

    void listQuickSort(ListNode node, int len) {
        if (len == 1) {
            return;
        } else if (len == 2) {
            if (node.val > node.next.val) {
                int tmp = node.val;
                node.val = node.next.val;
                node.next.val = tmp;
            }
        } else {
            ListNode pivot = node, i = node, j = node.next;
            int leftLen = 0, countMove = 0;
            while (countMove < len - 1 && j != null) {
                if (j.val < pivot.val) {
                    leftLen++; // left list will add one
                    i = i.next;
                    int tmp = j.val;
                    j.val = i.val;
                    i.val = tmp;
                }
                j = j.next;
                countMove++;
            }
            if (leftLen > 0) {
                int tmp = i.val;
                i.val = pivot.val;
                pivot.val = tmp;
                listQuickSort(node, leftLen);
            }
            if (len - leftLen > 1) {
                listQuickSort(i.next, len - leftLen - 1);
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}