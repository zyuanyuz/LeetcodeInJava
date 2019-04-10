package problems.medium;

/**
 * leetcode 98 ValidateBinarySearchTree Medium
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Example 1:
 * <p>
 * Input:
 * 2
 * / \
 * 1   3
 * Output: true
 * Example 2:
 * <p>
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 * is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
    //Memory Usage: 39.6 MB, less than 7.44% of Java online submissions for Validate Binary Search Tree.
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validNode(root, -2147483649L, 2147483648L);
    }

    private boolean validNode(TreeNode node, long leftWall, long rightWall) {
        if (node.val <= leftWall || node.val >= rightWall) return false;
        if (node.left != null) {
            if (!validNode(node.left, leftWall, (long) node.val)) return false;
        }
        if (node.right != null) {
            if (!validNode(node.right, (long) node.val, rightWall)) return false;
        }
        return true;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        //2147483647
        TreeNode(int x) {
            val = x;
        }
    }
}
