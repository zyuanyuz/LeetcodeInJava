package problems.medium;

/**
 * leetcode 114 FlattenBinaryTreetoLinkedList Meidum
 * 
 * Given a binary tree, flatten it to a linked list in-place.
 */

public class FlattenBinaryTreetoLinkedList {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Flatten Binary Tree to Linked List.
    //Memory Usage: 40.9 MB, less than 5.09% of Java online submissions for Flatten Binary Tree to Linked List.
    //bad memory usage , one more time!
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flattenTree(root);
    }

    public TreeNode flattenTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        } else {
            TreeNode linkNode = root;
            TreeNode leftFlatTree = flattenTree(root.left);
            TreeNode rightFlatTree = flattenTree(root.right);
            if (leftFlatTree != null) {
                root.left = null;
                linkNode = (root.right = leftFlatTree);
                while (linkNode.right != null) {
                    linkNode = linkNode.right;
                }
            }
            if (rightFlatTree != null) {
                linkNode.right = rightFlatTree;
            }
            return root;
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