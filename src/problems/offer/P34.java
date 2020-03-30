package problems.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class P34 {

    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 100.00% 的用户 内存消耗 : 41.8 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        rootPathToSum(result, new LinkedList<>(), root, 0, sum);
        return result;
    }

    void rootPathToSum(List<List<Integer>> result, LinkedList<Integer> path, TreeNode node, int nowSum, int targetSum) {
        nowSum += node.val;
        path.addLast(node.val);
        if (nowSum == targetSum && node.left == null && node.right == null) {
            result.add(new ArrayList<>(path));
            path.removeLast();
            return;
        }
        if (node.left != null)
            rootPathToSum(result, path, node.left, nowSum, targetSum);
        if (node.right != null)
            rootPathToSum(result, path, node.right, nowSum, targetSum);
        path.removeLast();
    }

    /**
     * extension:result contains all path sum equals sum instands of just root to
     * leaf node 扩展：打印出树所有和为sum的路径
     */
    public List<List<Integer>> pathSumIII(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        path(result, new LinkedList<>(), 0, root, 0, sum);
        return result;
    }

    void path(List<List<Integer>> result, LinkedList<Integer> pathList, int pathListStartIndex, TreeNode node,
            int nowSum, int targetSum) {
        nowSum += node.val;
        pathList.addLast(node.val);
        if (nowSum == targetSum) {
            List<Integer> list = new ArrayList<>(pathList.subList(pathListStartIndex, pathList.size()));
            result.add(list);
        } else if (nowSum > targetSum) {
            while (nowSum > targetSum && !pathList.isEmpty()) {
                nowSum -= pathList.peekFirst();
                pathListStartIndex++;
            }
            if (nowSum == targetSum) {
                List<Integer> list = new ArrayList<>(pathList.subList(pathListStartIndex, pathList.size()));
                result.add(list);
            }
        }
        if (node.left != null)
            path(result, pathList, pathListStartIndex, node.left, nowSum, targetSum);
        if (node.right != null)
            path(result, pathList, pathListStartIndex, node.right, nowSum, targetSum);
        if (!pathList.isEmpty())
            pathList.removeLast();
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