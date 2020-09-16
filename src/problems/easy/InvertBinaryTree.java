package problems.easy;

/**
 * leetcode 226
 */
public class InvertBinaryTree {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 36.5 MB , 在所有 Java 提交中击败了
     * 42.21% 的用户
     * 
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertDFS(root);
        return root;
    }

    private void invertDFS(TreeNode node) {
        if (node.left != null || node.right != null) {
            if (node.left != null) {
                invertDFS(node.left);
            }
            if (node.right != null) {
                invertDFS(node.right);
            }
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
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
