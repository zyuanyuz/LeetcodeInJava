package problems.easy;

/**
 * leetcode 104 Maximum Depth of Binary Tree Easy
 */

public class MaximumDepthofBinaryTree {
    int maxDepth = 0;

    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
    //Memory Usage: 38.9 MB, less than 97.48% of Java online submissions for Maximum Depth of Binary Tree.
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDepth;
        }
        recurcive(root, 1);
        return maxDepth;
    }

    public void recurcive(TreeNode node, int nowDepth) {
        if (node.left == null && node.right == null && nowDepth > maxDepth) {
            maxDepth = nowDepth;
        }
        if (node.left != null) {
            recurcive(node.left, nowDepth + 1);
        }
        if (node.right != null) {
            recurcive(node.right, nowDepth + 1);
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