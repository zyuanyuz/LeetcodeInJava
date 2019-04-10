package problems.easy;

/**
 * leetcode 100 SameTree Easy
 * Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */
public class SameTree {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
    //Memory Usage: 35.7 MB, less than 96.28% of Java online submissions for Same Tree.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return validNode(p, q);
    }

    private boolean validNode(TreeNode pNode, TreeNode qNode) {
        if (pNode.val != qNode.val) return false;
        if (pNode.left != null && qNode.left != null) {
            if (!validNode(pNode.left, qNode.left)) return false;
        } else if (!(pNode.left == null && qNode.left == null)) {
            return false;
        }
        if (pNode.right != null && qNode.right != null) {
            if (!validNode(pNode.right, qNode.right)) return false;
        } else if (!(pNode.right == null && qNode.right == null)) {
            return false;
        }
        return true;
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
