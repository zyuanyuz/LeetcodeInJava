package problems.medium;

/**
 * leetcode 64 Medium
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    //Runtime: 3 ms, faster than 99.26% of Java online submissions for Minimum Path Sum.
    //Memory Usage: 46.6 MB, less than 6.68% of Java online submissions for Minimum Path Sum.
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = n > 0 ? grid[0].length : 0;
        if (m == 0 || n == 0) {
            return 0;
        }
        for (int i = 1; i < m; i++) {   //the first row
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < n; i++) {  //the first column
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        return grid[n - 1][m - 1];
    }

    public void test() {

    }
}
