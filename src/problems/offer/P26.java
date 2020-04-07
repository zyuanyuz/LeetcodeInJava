package problems.offer;

public class P26 {

    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return isSubTree(A, B) || isSubStructure(A.right, B) || isSubStructure(A.left, B);
    }

    boolean isSubTree(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a != null && a.val == b.val) {
            return isSubTree(a.right, b.right) && isSubTree(a.left, b.left);
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