package problems.offer;

public class P04 {
    /**
     * 执行用时 : 1 ms , 在所有 Java 提交中击败了 35.72% 的用户 内存消耗 : 48.4 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}