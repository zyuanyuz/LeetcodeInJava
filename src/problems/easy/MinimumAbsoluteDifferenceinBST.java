package problems.easy;

/**
 * @author zyuanyuz
 * @since 2020/10/12 11:00
 */

/**
 * leetcode 530
 */
public class MinimumAbsoluteDifferenceinBST {

    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 82.46%
     * 的用户
     * 内存消耗：
     * 38.1 MB
     * , 在所有 Java 提交中击败了
     * 99.26%
     * 的用户
     */
    int min = Integer.MAX_VALUE;
    int prev = 0;
    boolean started = false;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        inorder(root);
        return min;
    }

    private void inorder(TreeNode node) {
        if (node.left != null) {
            inorder(node.left);
        }
        System.out.println(started + " " + node.val + " " + prev);
        if (started && min > Math.abs(node.val - prev)) {
            min = Math.abs(node.val - prev);
        }
        prev = node.val;
        started = true;

        if (node.right != null) {
            inorder(node.right);
        }
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
