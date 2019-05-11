package problems.medium;

/**
 * leetcode 147 InsertionSortList Medium
 */
public class InsertionSortList {
    //Runtime: 3 ms, faster than 98.14% of Java online submissions for Insertion Sort List.
    //Memory Usage: 37.7 MB, less than 60.49% of Java online submissions for Insertion Sort List.
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode resultFront = new ListNode(0);
        resultFront.next = head;
        ListNode tmpNode, moveNode;
        while (head != null && head.next != null) { // insert head.next into the before-list
            tmpNode = head.next;
            if (tmpNode.val < head.val) { // need insert into before-list
                head.next = tmpNode.next;
                moveNode = resultFront.next;
                if (moveNode.val > tmpNode.val) {// insert into the first place
                    tmpNode.next = moveNode;
                    resultFront.next = tmpNode;
                } else {
                    while (moveNode.next.val < tmpNode.val) {
                        moveNode = moveNode.next;
                    }
                    tmpNode.next = moveNode.next;
                    moveNode.next = tmpNode;
                }
            }else{
                head = head.next;
            }
        }
        return resultFront.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
