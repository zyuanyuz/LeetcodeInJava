package problems.medium;

/**
 * leetcode 62 Medium
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * <p>
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * Example 2:
 * <p>
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
    //Memory Usage: 31.6 MB, less than 100.00% of Java online submissions for Unique Paths.
    public int uniquePaths(int m, int n) {   //Catalan Number?
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] table = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            table[0][i] = 0;
        }
        for (int i = 0; i < n + 1; i++) {
            table[i][0] = 0;
        }
        table[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                table[i][j] = table[i][j - 1] + table[i - 1][j];
            }
        }
        return table[n][m];
    }

    public void test() {
        System.out.println(uniquePaths(25, 9));
    }
}
