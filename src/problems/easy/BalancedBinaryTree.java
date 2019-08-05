package problems.easy;

/**
 * leetcode 110 BalancedBinaryTree Easy
 */
public class BalancedBinaryTree {
    //Runtime: 3 ms, faster than 6.12% of Java online submissions for Balanced Binary Tree.
    //Memory Usage: 41.3 MB, less than 14.02% of Java online submissions for Balanced Binary Tree.
    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return result;
        }
        System.out.println(nodeMostDeepth(root));
        return result;
    }

    int nodeMostDeepth(TreeNode node) {
        if (result == false) {
            return -1;
        }
        int leftDeepth = 0;
        int rightDeepth = 0;
        if (node.left != null) {
            leftDeepth = nodeMostDeepth(node.left);
        }
        if (node.right != null) {
            rightDeepth = nodeMostDeepth(node.right);
        }
        int difDeepth = leftDeepth - rightDeepth;
        if (difDeepth > 1 || difDeepth < -1) {
            result = false;
        }
        return leftDeepth > rightDeepth ? leftDeepth + 1 : rightDeepth + 1;
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