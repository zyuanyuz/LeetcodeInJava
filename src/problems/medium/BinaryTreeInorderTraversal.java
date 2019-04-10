package problems.medium;

import java.util.*;

/**
 * leetcode 94 BinaryTreeInorderTraversal Medium
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * <p>
 * Example:
 * <p>
 * Input: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * Output: [1,3,2]
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
    //Runtime: 1 ms, faster than 30.29% of Java online submissions for Binary Tree Inorder Traversal.
    //Memory Usage: 36.1 MB, less than 59.04% of Java online submissions for Binary Tree Inorder Traversal.
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            TreeNode tmpRoot;
            while (nodeStack.peek().left != null) {
                tmpRoot = nodeStack.peek().left;
                nodeStack.peek().left = null;
                nodeStack.push(tmpRoot);
            }
            tmpRoot = nodeStack.pop();
            result.add(tmpRoot.val);
            if (tmpRoot.right != null) {
                nodeStack.push(tmpRoot.right);
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
