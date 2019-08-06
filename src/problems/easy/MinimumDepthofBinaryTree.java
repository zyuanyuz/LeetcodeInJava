package problems.easy;

/**
 * leetcode 111 MinimumDepthofBinaryTree Easy
 */
public class MinimumDepthofBinaryTree {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
    //Memory Usage: 38.7 MB, less than 97.79% of Java online submissions for Minimum Depth of Binary Tree.
    int minDeepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        getMinDeepth(root, 0);
        return minDeepth;
    }

    void getMinDeepth(TreeNode node, int deepth) {
        if (node.left == null && node.right == null) {
            if (deepth + 1 < minDeepth)
                minDeepth = ++deepth;
        }
        if (node.left != null) {
            getMinDeepth(node.left, deepth + 1);
        }
        if (node.right != null) {
            getMinDeepth(node.right, deepth + 1);
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