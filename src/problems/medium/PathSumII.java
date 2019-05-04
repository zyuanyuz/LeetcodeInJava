package problems.medium;

import java.util.*;

/**
 * leetcode 113 PathSumII Medium
 * 
 */
public class PathSumII {
    //Runtime: 1 ms, faster than 99.96% of Java online submissions for Path Sum II.
    //Memory Usage: 39.3 MB, less than 72.89% of Java online submissions for Path Sum II.
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return result;
        List<Integer> tmpList = new ArrayList<>();
        tmpList.add(root.val);
        backtracking(tmpList, root.val, sum, root);
        return result;
    }

    // must be the leaf node
    private void backtracking(List<Integer> tmpList, int tmpSum, int targetSum, TreeNode node) {
        if (node.left == null && node.right == null && tmpSum == targetSum) {
            result.add(new ArrayList<>(tmpList));
        } else {
            if (node.left != null) {
                tmpList.add(node.left.val);
                tmpSum += node.left.val;
                backtracking(tmpList, tmpSum, targetSum, node.left);
                tmpList.remove(tmpList.size() - 1);
                tmpSum -= node.left.val;
            }

            if (node.right != null) {
                tmpList.add(node.right.val);
                tmpSum += node.right.val;
                backtracking(tmpList, tmpSum, targetSum, node.right);
                tmpList.remove(tmpList.size() - 1);
                tmpSum -= node.right.val;
            }
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

    // 5,4,8,11,null,13,4,7,2,null,null,5,1
}