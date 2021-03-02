package problems.medium;

/**
 * leetcode 304
 */
public class RangeSumQuery2DImmutable {
    /**
     * 执行用时：
     * 14 ms
     * , 在所有 Java 提交中击败了
     * 98.81%
     * 的用户
     * 内存消耗：
     * 44.1 MB
     * , 在所有 Java 提交中击败了
     * 49.05%
     * 的用户
     */
    public static
    class NumMatrix {

        int[][] preSumMatrix;

        public NumMatrix(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }
            preSumMatrix = new int[matrix.length + 1][matrix[0].length + 1];
            for (int i = 0; i <= matrix.length; i++) {
                preSumMatrix[i][0] = 0;
            }
            for (int i = 0; i <= matrix[0].length; i++) {
                preSumMatrix[0][i] = 0;
            }
            for (int i = 1; i <= matrix.length; i++) {
                for (int j = 1; j <= matrix[0].length; j++) {
                    preSumMatrix[i][j] = matrix[i - 1][j - 1] +
                            preSumMatrix[i - 1][j] + preSumMatrix[i][j - 1] - preSumMatrix[i - 1][j - 1];
                }
            }

            for (int[] row : preSumMatrix) {
                for (int n : row) {
                    System.out.print(n + " ");
                }
                System.out.println();
            }

        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return preSumMatrix[row2 + 1][col2 + 1] - preSumMatrix[row1][col2 + 1]
                    - preSumMatrix[row2 + 1][col1] + preSumMatrix[row1][col1];
        }
    }
}
