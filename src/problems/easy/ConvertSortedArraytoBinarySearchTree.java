package problems.easy;

/**
 * leetcode 108 ConvertSortedArraytoBinarySearchTree Easy
 */
public class ConvertSortedArraytoBinarySearchTree {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    //Memory Usage: 37 MB, less than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return makeTree(nums, 0, nums.length - 1);
    }

    TreeNode makeTree(int[] nums, int s, int e) {
        if (e < s) {
            return null;
        } else if (e == s) {
            return new TreeNode(nums[s]);
        }
        int pivot = (s + e + 1) / 2 ;
        TreeNode node = new TreeNode(nums[pivot]);
        node.left = makeTree(nums, s, pivot - 1);
        node.right = makeTree(nums, pivot + 1, e);
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