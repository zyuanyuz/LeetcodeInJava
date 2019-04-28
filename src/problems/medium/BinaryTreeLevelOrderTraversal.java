package problems.medium;

import java.util.*;

/**
 * leetcode 102 BinaryTreeLevelOrderTraversal Medium
 * 
 */
public class BinaryTreeLevelOrderTraversal{
    //Runtime: 1 ms, faster than 75.35% of Java online submissions for Binary Tree Level Order Traversal.
    //Memory Usage: 37.4 MB, less than 42.35% of Java online submissions for Binary Tree Level Order Traversal.
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null)return result;
        Queue<TreeNode> queueone = new LinkedList<>();
        Queue<TreeNode> queuetwo = new LinkedList<>();
        boolean queueSwitch = true;
        queueone.offer(root);
        while (!queueone.isEmpty() || !queuetwo.isEmpty()) {
            Queue<TreeNode> queueTake = queueSwitch ? queueone : queuetwo;
            Queue<TreeNode> queueOffer = queueSwitch ? queuetwo : queueone;
            List<Integer> oneResult = new ArrayList<>();
            while (!queueTake.isEmpty()) {
                TreeNode node = queueTake.poll();
                oneResult.add(node.val);
                if (node.left != null) {
                    queueOffer.offer(node.left);
                }
                if (node.right != null) {
                    queueOffer.offer(node.right);
                }
            }
            queueSwitch = !queueSwitch;
            result.add(oneResult);
        }
        return result;
    }
    class TreeNode{
        int val; 
        TreeNode left; 
        TreeNode right; 
        TreeNode(int x) { val = x; } 
    }
}