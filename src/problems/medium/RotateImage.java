package problems.medium;

/**
 * leetcode 48 Medium
 * <p>
 * You are given an n x n 2D matrix representing an image.
 * <p>
 * Rotate the image by 90 degrees (clockwise).
 * <p>
 * Note:
 * <p>
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 * <p>
 * Example 1:
 * <p>
 * Given input matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * rotate the input matrix in-place such that it becomes:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 */
public class RotateImage {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Rotate Image.
    //Memory Usage: 37.4 MB, less than 14.09% of Java online submissions for Rotate Image.
    public void rotate(int[][] matrix) {
        int tmp1, tmp2, wall;
        for (int floor = 0; floor < matrix.length / 2; floor++) {
            wall = matrix.length - floor - 1;
            for (int i = floor; i < wall; i++)
            {
                //关键点是对于每个点的位置的坐标表示
                //
                tmp1 = matrix[i][wall];
                matrix[i][wall] = matrix[floor][i];
                //为什么是wall+floor-i，因为这里是以 floor 为基准点而言的，是 wall-(i-floor)
                tmp2 = matrix[wall][wall + floor - i];
                matrix[wall][wall + floor - i] = tmp1;
                //
                tmp1 = matrix[wall + floor - i][floor];
                matrix[wall + floor - i][floor] = tmp2;
                //
                matrix[floor][i] = tmp1;
            }
        }
    }

    public void test() {
        //{1, 2}, {3, 4}
        //{1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        //{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}
        //{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}
        int[][] matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        rotate(matrix);
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + "\t");
            }
            System.out.println();
        }
    }
}
