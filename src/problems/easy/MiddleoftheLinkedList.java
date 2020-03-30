package problems.easy;

public class MiddleoftheLinkedList {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 37.1 MB , 在所有 Java 提交中击败了
     * 5.05% 的用户
     */
    public ListNode middleNode(ListNode head) {
        int length = 0;
        ListNode moveNode = head;
        while (moveNode != null) {
            length++;
            moveNode = moveNode.next;
        }
        int target = length / 2 + 1;
        moveNode = head;
        for (int i = 1; i < target; i++) {
            moveNode = moveNode.next;
        }
        return moveNode;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}