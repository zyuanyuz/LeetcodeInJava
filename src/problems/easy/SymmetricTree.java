package problems.easy;

/**
 * leetcode 101 SymmetricTree Easy
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 */
public class SymmetricTree {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
    //Memory Usage: 38.6 MB, less than 43.66% of Java online submissions for Symmetric Tree.
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        TreeNode leftNode = root.left, rightNode = root.right;
        if (leftNode == null && rightNode == null) return true;
        else if (leftNode == null || rightNode == null) return false;
        return isNodeSym(leftNode, rightNode);
    }

    private boolean isNodeSym(TreeNode nodeOne, TreeNode nodeTwo) {
        if (nodeOne == null && nodeTwo == null) {
            return true;
        } else if (nodeOne == null || nodeTwo == null) {
            return false;
        } else if (nodeOne.val == nodeTwo.val) {
            return isNodeSym(nodeOne.left, nodeTwo.right) && isNodeSym(nodeOne.right, nodeTwo.left);
        } else {
            return false;
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
