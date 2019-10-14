package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 109 ConvertSortedListtoBinarySearchTree Medium
 * 
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 */

public class ConvertSortedListtoBinarySearchTree {
    //Runtime: 2 ms, faster than 22.15% of Java online submissions for Convert Sorted List to Binary Search Tree.
    //Memory Usage: 40 MB, less than 44.74% of Java online submissions for Convert Sorted List to Binary Search Tree.
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> valueList = new ArrayList<>();
        while (head != null) {
            valueList.add(head.val);
            head = head.next;
        }
        return getTreeNode(valueList, 0, valueList.size());
    }

    public TreeNode getTreeNode(List<Integer> list, int start, int end) {
        if (start == end - 1) {
            return new TreeNode(list.get(start));
        } else if (start < end) {
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(list.get(mid));
            node.left = getTreeNode(list, start, mid);
            node.right = getTreeNode(list, mid + 1, end);
            return node;
        } else {
            return null;  
        }
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