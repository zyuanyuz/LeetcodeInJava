package problems.medium;

import java.util.*;

/**
 * leetcode 95 UniqueBinarySearchTreesII Medium
 */
public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
        Map<Integer, NNodeTree> tMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {

        }
        return tMap.get(n).rootNodeList;
    }

    class NNodeTree {
        List<TreeNode> treeNodeList = new ArrayList<>();
        List<TreeNode> rootNodeList = new ArrayList<>();
        int minValue;
        int n;

        NNodeTree(int n, NNodeTree baseTree, Map<Integer, NNodeTree> tMap) {
            if (baseTree == null) {
                this.n = 1;
                TreeNode node = new TreeNode(1);
                this.treeNodeList.add(node);
                this.treeNodeList.add(node);
                this.minValue = 1;
                tMap.put(1, this);
            } else {
                this.n = n;
                for (int i = 0; i < n; i++) {
                    TreeNode node = new TreeNode(n);
                    if (i != 0) {
                        tMap.get(i);
                    }else{
                        
                    }
                    if (n - i - 1 != 0) {
                        tMap.get(n - i - 1).rootNodeList.get(1);
                    }
                }
            }
        }

        public void allAdd(int value) {
            minValue += value;
            for (TreeNode node : treeNodeList) {
                node.val += value;
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
}
