package problems.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 501
 */
public class FindModeinBinarySearchTree {
    /**
     * 执行用时： 0 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗： 39.6 MB , 在所有 Java 提交中击败了
     * 38.50% 的用户
     */
    int maxCount = 0;
    int nowCount = 0;
    int nowValue;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> modeArray = new ArrayList<>();
        countMode(modeArray, root);
        int[] result = new int[modeArray.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = modeArray.get(i);
        }
        return result;
    }

    private void countMode(List<Integer> modeArray, TreeNode node) {
        if (node.left != null) {
            countMode(modeArray, node.left);
        }
        if (nowValue == node.val) {
            nowCount++;
        } else {
            nowValue = node.val;
            nowCount = 1;
        }
        if (nowCount == maxCount) {
            modeArray.add(node.val);
        }
        if (nowCount > maxCount) {
            modeArray.clear();
            modeArray.add(nowValue);
            maxCount = nowCount;
        }
        if (node.right != null) {
            countMode(modeArray, node.right);
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
