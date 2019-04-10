package problems.medium;

import java.util.*;

/**
 * leetcode 54 Medium
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in spiral order.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 * Example 2:
 * <p>
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class SpiralMatrix {
    //Runtime: 1 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
    //Memory Usage: 37.2 MB, less than 15.57% of Java online submissions for Spiral Matrix.
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int floor = 0, rightWall = matrix[0].length - 1, downWall = matrix.length - 1;
        List<Integer> result = new ArrayList<>();
        //关注这种非对称式的矩阵如何设定floor的值来控制循环。
        for (; floor < Math.min((matrix.length + 1) / 2, (matrix[0].length + 1) / 2)
                ; floor++, rightWall--, downWall--) {
            for (int i = floor; i <= rightWall; i++) {  //注意这里的最后一个中心数的问题
                result.add(matrix[floor][i]);
            }
            for (int i = floor + 1; i <= downWall; i++) {
                result.add(matrix[i][rightWall]);
            }
            for (int i = rightWall - 1; downWall != floor && i > floor; i--) {  //注意这里的可能重复的问题
                result.add(matrix[downWall][i]);
            }
            for (int i = downWall; rightWall != floor && i > floor; i--) {
                result.add(matrix[i][floor]);
            }
        }
        return result;
    }

    public void test() {
        // { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }
        // {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}
        //{1,2,3,10,11},{4,5,6,13,14},{7,8,9,16,17},{19,20,21,22,23},{24,25,26,27,28}
        //{1,2,3,4,5}
        //{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}
        //{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}
        int[][] matrix = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}, {11, 12}};
        System.out.println(spiralOrder(matrix));
    }
}
