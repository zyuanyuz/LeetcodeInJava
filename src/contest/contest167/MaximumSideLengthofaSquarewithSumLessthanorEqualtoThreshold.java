package contest.contest167;

/**
 * leetcode 5285 Medium
 */
public class MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold {

    /**
     * 执行用时 : 1600 ms , 在所有 java 提交中击败了 100.00% 的用户 内存消耗 : 58.7 MB , 在所有 java 提交中击败了
     * 100.00% 的用户
     */
    public int maxSideLength(int[][] mat, int threshold) {
        int rowLength = mat.length;
        int colLength = mat[0].length;
        int length = Math.min(rowLength, colLength);
        for (; length > 0; length--) {
            int initSum = 0;
            for (int i = 0; i < length; i++) { // init the sum for this length
                for (int j = 0; j < length; j++) {
                    initSum += mat[i][j];
                }
            }
            int rowDirectSum = initSum;
            int i = 0;
            do {
                if (rowDirectSum <= threshold) {
                    System.out.println("result one:" + length + " " + i + "-" + 0 + " sum:" + rowDirectSum
                            + " threshold:" + threshold);
                    return length;
                }
                int colDirectSum = rowDirectSum;
                int j = 0;
                do {
                    if (colDirectSum <= threshold) {
                        System.out.println("result two:" + length + " " + i + "-" + j + " sum:" + rowDirectSum
                                + " threshold:" + threshold);
                        return length;
                    }
                    for (int y = i; j + length < colLength && y < i + length; y++) {
                        colDirectSum = colDirectSum + mat[y][j + length] - mat[y][j];
                    }
                    j++;
                } while (j <= colLength - length);
                for (int x = 0; i + length < rowLength && x < length; x++) {
                    rowDirectSum = rowDirectSum + mat[i + length][x] - mat[i][x];
                }
                i++;
            } while (i <= rowLength - length);
        }
        return 0;
    }

    public static void main(String[] args) {
        MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold m = new MaximumSideLengthofaSquarewithSumLessthanorEqualtoThreshold();
        int[][] mat = new int[][] { { 2, 2, 2, 2, 2 }, { 2, 3, 2, 2, 2 }, { 2, 2, 2, 2, 1 }, { 2, 2, 2, 2, 2 },
                { 2, 2, 2, 2, 2 } };
        // int threshold = 18;
        // for (int i = 100; i > 0; i--) {
        // m.maxSideLength(mat, i);
        // }
        m.maxSideLength(mat, 17);
    }
}