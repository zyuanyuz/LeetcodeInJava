package problems.medium;

/**
 * leetcode 63 Medium
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
    //Memory Usage: 36.1 MB, less than 80.08% of Java online submissions for Unique Paths II.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = n > 0 ? obstacleGrid[0].length : 0;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] table = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            table[i][0] = 0;
        }
        table[1][1] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (obstacleGrid[i - 1][j - 1] == 1) {
                    table[i][j] = 0;
                } else {
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
                }
            }
        }
        return table[n][m];
    }

    public void test() {
        //run on leetcode.com
    }
}
