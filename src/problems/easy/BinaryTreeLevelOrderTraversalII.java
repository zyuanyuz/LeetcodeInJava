package problems.easy;

import java.util.List;
import java.util.ArrayList;

/**
 * leetcode 107 BinaryTreeLevelOrderTraversalII Easy
 */

public class BinaryTreeLevelOrderTraversalII {
    //Runtime: 1 ms, faster than 97.85% of Java online submissions for Binary Tree Level Order Traversal II.
    //Memory Usage: 36.5 MB, less than 100.00% of Java online submissions for Binary Tree Level Order Traversal II.
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        makeupList(result, root, 0);
        return result;
    }

    public void makeupList(List<List<Integer>> result, TreeNode node, int deepth) {
        if (result.size() < deepth + 1) {
            result.add(0, new ArrayList<>());
        }
        result.get(result.size() - deepth - 1).add(node.val);
        if (node.left != null) {
            makeupList(result, node.left, deepth + 1);
        }
        if (node.right != null) {
            makeupList(result, node.right, deepth + 1);
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