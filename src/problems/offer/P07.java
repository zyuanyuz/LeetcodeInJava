package problems.offer;

public class P07 {
    /**
     * 执行用时 : 4 ms , 在所有 Java 提交中击败了 69.96% 的用户 内存消耗 : 39.7 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;
        return buildSubTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    // include the start index,exclude the endindex
    TreeNode buildSubTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart >= preEnd || inStart >= inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inOrderRootIndex = 0, leftSize = 0, rightSize = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                inOrderRootIndex = i;
                leftSize = inOrderRootIndex - inStart;
                rightSize = inEnd - inOrderRootIndex - 1;
                break;
            }
        }
        root.left = leftSize > 0
                ? buildSubTree(preorder, preStart + 1, preStart + leftSize + 1, inorder, inStart, inStart + leftSize)
                : null;
        root.right = rightSize > 0
                ? buildSubTree(preorder, preStart + leftSize + 1, preEnd, inorder, inOrderRootIndex + 1, inEnd)
                : null;
        return root;
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