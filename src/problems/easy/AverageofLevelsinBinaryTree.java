package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * leetcode 637
 */
public class AverageofLevelsinBinaryTree {
    /**
     * 执行用时： 3 ms , 在所有 Java 提交中击败了 73.65% 的用户 内存消耗： 41.4 MB , 在所有 Java 提交中击败了
     * 66.78% 的用户
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgList = new ArrayList<>();
        bfs(Arrays.asList(root), avgList);
        return avgList;
    }

    private void bfs(List<TreeNode> nowNodes, List<Double> resultList) {
        List<TreeNode> nextNodes = new ArrayList<>();
        long count = 0;
        for (TreeNode node : nowNodes) {
            if (node.left != null)
                nextNodes.add(node.left);
            if (node.right != null)
                nextNodes.add(node.right);
            count += node.val;
        }
        resultList.add((double) count / (double) nowNodes.size());
        if (!nextNodes.isEmpty())
            bfs(nextNodes, resultList);
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