package problems.medium;

/**
 * leetcode 129 SumRoottoLeafNumbers Medium
 */
public class SumRoottoLeafNumbers {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
    //Memory Usage: 36.8 MB, less than 79.95% of Java online submissions for Sum Root to Leaf Numbers.
    int resultSum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        addNode(0, root);
        return resultSum;
    }

    public void addNode(int tmpSum, TreeNode node) {
        if (node.left == null && node.right == null) {
            resultSum += tmpSum * 10 + node.val;
        } else {
            tmpSum = tmpSum * 10 + node.val;
            if (node.left != null) {
                addNode(tmpSum, node.left);
            }
            if (node.right != null) {
                addNode(tmpSum, node.right);
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