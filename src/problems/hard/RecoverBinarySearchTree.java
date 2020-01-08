package problems.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 99 RecoverBinarySearchTree Hard A solution using O(n) space is
 * pretty straight forward. Could you devise a constant space solution?
 */
public class RecoverBinarySearchTree {
    /**
     * 执行用时 : 3 ms , 在所有 Java 提交中击败了 67.38% 的用户 内存消耗 : 40.6 MB , 在所有 Java 提交中击败了
     * 90.42% 的用户
     * 
     * @param root
     */
    public void recoverTree(TreeNode root) {
        List<TreeNode> treeList = new ArrayList<>();
        travelNodes(root, treeList);
        TreeNode one = null;
        int countDown = 0, oneIndex = 0;
        for (int i = 0; i < treeList.size(); i++) {
            if (i < treeList.size() - 1 && treeList.get(i).val > treeList.get(i + 1).val) {
                countDown++;
                if (one == null) {
                    one = treeList.get(i);
                    oneIndex = i;
                }
            }
            if (countDown == 2) {
                one.val += treeList.get(i + 1).val;
                treeList.get(i + 1).val = one.val - treeList.get(i + 1).val;
                one.val -= treeList.get(i + 1).val;
                return;
            }
        }
        if (countDown == 1) {
            one.val += treeList.get(oneIndex + 1).val;
            treeList.get(oneIndex + 1).val = one.val - treeList.get(oneIndex + 1).val;
            one.val -= treeList.get(oneIndex + 1).val;
        }
    }

    private void travelNodes(TreeNode root, List<TreeNode> treeList) {
        if (root.left != null)
            travelNodes(root.left, treeList);
        treeList.add(root);
        if (root.right != null)
            travelNodes(root.right, treeList);
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        TreeNode root = r.new TreeNode(4);
        TreeNode left = r.new TreeNode(5);
        left.left = r.new TreeNode(1);
        left.right = r.new TreeNode(3);
        root.left = left;
        root.right = r.new TreeNode(2);
        r.recoverTree(root);
    }
    /**
     * [1,3,null,null,2] [3,1,4,null,null,2] [4,5,2,1,3] [1,2,5,4,3] [2,2,5,4,3]
     */
}
