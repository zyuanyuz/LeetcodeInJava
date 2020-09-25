package problems.easy;

/**
 * leetcode 617
 */
public class MergeTwoBinaryTrees {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 64.02% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了
     * 61.05% 的用户
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 != null) {
            return t2;
        } else if (t1 == null) {
            return null;
        }
        return mergeTreeNode(t1, t2);
    }

    private TreeNode mergeTreeNode(TreeNode node1, TreeNode node2) {
        if (node2 != null) {
            node1.val += node2.val;
        }
        if (node1.left == null && node2 != null && node2.left != null) {
            node1.left = new TreeNode(0);
        }
        if (node1.left != null) {
            mergeTreeNode(node1.left, node2 == null || node2.left == null ? null : node2.left);
        }

        if (node1.right == null && node2 != null && node2.right != null) {
            node1.right = new TreeNode(0);
        }
        if (node1.right != null) {
            mergeTreeNode(node1.right, node2 == null || node2.right == null ? null : node2.right);
        }

        return node1;
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