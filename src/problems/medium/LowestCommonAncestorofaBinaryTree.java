package problems.medium;

/**
 * @author zyuanyuz
 * @since 2020/10/20 20:58
 */

import java.util.LinkedList;

/**
 * leetcode 236
 */
public class LowestCommonAncestorofaBinaryTree {
    /**
     * 执行用时：
     * 8 ms
     * , 在所有 Java 提交中击败了
     * 61.19%
     * 的用户
     * 内存消耗：
     * 40.3 MB
     * , 在所有 Java 提交中击败了
     * 96.27%
     * 的用户
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pParentList = new LinkedList<>();
        LinkedList<TreeNode> qParentList = new LinkedList<>();
        findParent(pParentList, root, p);
        findParent(qParentList, root, q);

        while (!pParentList.isEmpty()) {
            TreeNode node = pParentList.pollLast();
            for (int i = qParentList.size() - 1; i >= 0; i--) {
                if (qParentList.get(i) == node) {
                    return node;
                }
            }
        }
        return null;
    }

    private boolean findParent(LinkedList<TreeNode> list, TreeNode node, TreeNode target) {
        list.addLast(node);
        if (node == target) {
            return true;
        }
        if (node.left != null && findParent(list, node.left, target)) {
            return true;
        }
        if (node.right != null && findParent(list, node.right, target)) {
            return true;
        }
        list.removeLast();
        return false;
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
