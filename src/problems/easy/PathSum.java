package problems.easy;

/**
 * leetcode 112 PathSum Easy
 */

public class PathSum {
    // Runtime: 0 ms, faster than 100.00% of Java online submissions for Path Sum.
    // Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for Path
    // Sum.
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasSumToLeaf(root, sum, 0);
    }

    private boolean hasSumToLeaf(TreeNode node, int sum, int nowSum) {
        if (node.left == null && node.right == null) {
            if (sum == nowSum + node.val) {
                return true;
            } else {
                return false;
            }
        }
        if ((node.left != null && hasSumToLeaf(node.left, sum, nowSum + node.val))
                || (node.right != null && hasSumToLeaf(node.right, sum, nowSum + node.val))) {
            return true;
        }
        return false;
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