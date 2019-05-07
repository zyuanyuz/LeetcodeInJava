package problems.medium;

import java.util.*;

/**
 * leetcode 144 BinaryTreePreorderTraversal Medium
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class BinaryTreePreorderTraversal {
    // Runtime: 1 ms, faster than 35.79% of Java online submissions for Binary Tree
    // Preorder Traversal.
    // Memory Usage: 33.9 MB, less than 93.91% of Java online submissions for Binary
    // Tree Preorder Traversal.
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        result.add(root.val);
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.peek();
            if (node.left != null) {
                result.add(node.left.val);
                nodeStack.push(node.left);
                node.left = null;
            } else if (node.right != null) {
                result.add(node.right.val);
                nodeStack.push(node.right);
                node.right = null;
            } else {
                nodeStack.pop();
            }
        }
        return result;
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