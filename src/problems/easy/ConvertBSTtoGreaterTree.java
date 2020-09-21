package problems.easy;

/**
 * leetcode 538
 */
public class ConvertBSTtoGreaterTree {
    /**
     * 执行用时： 1 ms , 在所有 Java 提交中击败了 97.82% 的用户 内存消耗： 38.9 MB , 在所有 Java 提交中击败了
     * 71.82% 的用户
     */
    private int count = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        order(root);
        return root;
    }

    private void order(TreeNode node) {
        if (node.right != null) {
            order(node.right);
        }
        int tmp = node.val;
        node.val += count;
        count += tmp;
        if (node.left != null) {
            order(node.left);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}