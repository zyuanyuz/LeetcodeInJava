package problems.medium;

/**
 * leetcode 59 Medium
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Spiral Matrix II.
    //Memory Usage: 36.8 MB, less than 58.01% of Java online submissions for Spiral Matrix II.
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[0][0];
        }
        int[][] result = new int[n][n];
        int floor = 0, wall = n - 1, count = 1;
        for (; floor < (n + 1) / 2; floor++) {
            wall = n - floor - 1;
            for (int i = floor; i <= wall; i++) {   //to right
                result[floor][i] = count++;
            }
            for (int i = floor + 1; i < wall; i++) {
                result[i][wall] = count++;
            }
            for (int i = wall; i > floor; i--) {
                result[wall][i] = count++;
            }
            for (int i = wall; i > floor; i--) {
                result[i][floor] = count++;
            }
        }
        return result;
    }

    public void test() {
        int[][] result = generateMatrix(6);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
