package contest.contest178;

public class LinkedListinBinaryTree {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null) return false;
        return isSameVal(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    boolean isSameVal(ListNode listNode, TreeNode treeNode) {
        if (listNode == null)
            return true;
        if (treeNode == null)
            return false;
        if (listNode.val != treeNode.val)
            return false;
        return isSameVal(listNode.next, treeNode.left) || isSameVal(listNode.next, treeNode.right);
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}