package problems.medium;

/**
 * leetcode 96 UniqueBinarySearchTrees Medium
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class UniqueBinarySearchTrees {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
    //Memory Usage: 31.6 MB, less than 100.00% of Java online submissions for Unique Binary Search Trees.
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] bstCount = new int[n + 1];
        bstCount[0] = 1;
        bstCount[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                bstCount[i] += bstCount[j - 1] * bstCount[i - j];
            }
        }
        for (int num : bstCount) {
            System.out.print(num + "\t");
        }
        return bstCount[n];
    }

}
