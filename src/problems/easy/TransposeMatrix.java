package problems.easy;

/**
 * leetcode 867
 */
public class TransposeMatrix {
    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 38.34%
     * 的用户
     * 内存消耗：
     * 39.5 MB
     * , 在所有 Java 提交中击败了
     * 16.77%
     * 的用户
     *
     * @param matrix
     * @return
     */
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
}
