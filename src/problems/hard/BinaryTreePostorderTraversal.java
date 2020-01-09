package problems.hard;

import java.util.ArrayList;
import java.util.List;

//leetcode 145 BinaryTreePostorderTraversal Hard

public class BinaryTreePostorderTraversal {
    /**
     * 执行用时 : 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 35 MB , 在所有 Java 提交中击败了
     * 37.05% 的用户
     * 
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root != null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        traversalNode(root, list);
        return list;
    }

    private void traversalNode(TreeNode root, List<Integer> list) {
        if (root.left != null)
            traversalNode(root.left, list);
        if (root.right != null)
            traversalNode(root.right, list);
        list.add(root.val);
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