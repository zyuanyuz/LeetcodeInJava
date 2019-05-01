package problems.medium;

/**
 * leetcode 106 ConstructBinaryTreefromInorderandPostorderTraversal Medium
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * inorder = [9,3,15,20,7] postorder = [9,15,7,20,3]
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    // Runtime: 7 ms, faster than 44.06% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    // Memory Usage: 37.6 MB, less than 43.09% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        return buildTreeNode(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    TreeNode buildTreeNode(int[] inorder, int instart, int inend, int[] postorder, int poststart, int postend) {
        TreeNode node = new TreeNode(postorder[postend - 1]);
        int leftTreeSize = 0;
        int rightTreeSize = 0;
        for (int i = instart; i < inend; i++) {
            if (inorder[i] == postorder[postend - 1]) {
                leftTreeSize = i - instart;
                rightTreeSize = inend - i - 1;
                break;
            }
        }
        if (leftTreeSize > 0)
            node.left = buildTreeNode(inorder, instart, instart + leftTreeSize, postorder, poststart,
                    poststart + leftTreeSize);
        if (rightTreeSize > 0)
            node.right = buildTreeNode(inorder, instart + leftTreeSize + 1, inend, postorder, poststart + leftTreeSize,
                    postend - 1);
        return node;
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