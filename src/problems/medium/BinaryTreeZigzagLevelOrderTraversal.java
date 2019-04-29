package problems.medium;

import java.util.*;

/**
 * leetcode 103 BinaryTreeZigzagLevelOrderTraversal Medium
 */

public class BinaryTreeZigzagLevelOrderTraversal {
    //Runtime: 1 ms, faster than 75.42% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    //Memory Usage: 37.4 MB, less than 5.10% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> queueone = new Stack<>();
        Stack<TreeNode> queuetwo = new Stack<>();
        queueone.push(root);
        boolean queueSwitch = true;
        while (!queueone.isEmpty() || !queuetwo.isEmpty()) {
            Stack<TreeNode> queueTake = queueSwitch ? queueone : queuetwo;
            Stack<TreeNode> queueOffer = queueSwitch ? queuetwo : queueone;
            List<Integer> oneResult = new ArrayList<>();
            while (!queueTake.isEmpty()) {
                TreeNode node = queueTake.pop();
                oneResult.add(node.val);
                TreeNode nodeone = queueSwitch ? node.left : node.right;
                TreeNode nodetwo = queueSwitch ? node.right : node.left;
                if (nodeone != null)
                    queueOffer.push(nodeone);
                if (nodetwo != null)
                    queueOffer.push(nodetwo);
            }
            queueSwitch = !queueSwitch;
            result.add(oneResult);
        }
        return result;
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
