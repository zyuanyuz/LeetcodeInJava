package problems.medium;

/**
 * leetcode 105 ConstructBinaryTreefromPreorderandInorderTraversal Medium
 */

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    //Runtime: 12 ms, faster than 21.78% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    //Memory Usage: 37.6 MB, less than 33.13% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0)
            return null;
        return buildTreeNode(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // include the *start ,exclude the *end
    private TreeNode buildTreeNode(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        TreeNode node = new TreeNode(preorder[prestart]);
        int leftTreeSize = 0;
        int rightTreeSize = 0;
        for (int i = instart; i < inend; i++) {
            if (inorder[i] == node.val) {
                leftTreeSize = i - instart;
                rightTreeSize = inend - i - 1;
                break;
            }
        }
        if (leftTreeSize > 0) {
            node.left = buildTreeNode(preorder, prestart + 1, prestart + 1 + leftTreeSize, inorder, instart,
                    instart + leftTreeSize);
        }
        if (rightTreeSize > 0) {
            node.right = buildTreeNode(preorder, prestart + 1 + leftTreeSize, preend, inorder, instart + leftTreeSize + 1,
                    inend);
        }
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