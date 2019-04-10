package problems.medium;

/**
 * leetcode 74 Searcha2DMatrix Medium
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 * <p>
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 * <p>
 * Input:
 * matrix = [
 * [1,   3,  5,  7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Searcha2DMatrix {
    //Runtime: 4 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
    //Memory Usage: 39.5 MB, less than 22.57% of Java online submissions for Search a 2D Matrix.
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] <= target) {
                row = i;
            } else {
                break;
            }
        }
        if (row <= -1) {
            return false;
        }
        return matrix[row][0] == target || binarySearch(matrix[row], target, 0, matrix[row].length - 1);
    }

    //bugs int here
    int binaryRow(int[][] matrix, int target, int start, int end) {

        return -1;
    }

    boolean binarySearch(int[] row, int target, int start, int end) {

        if (start == end && row[start] != target) {
            return false;
        } else if (start == end && row[start] == target) {
            return true;
        } else if (start < end) {
            int middle = (start + end) / 2;
            if (row[middle] == target) {
                return true;
            } else if (row[middle] > target) {
                return binarySearch(row, target, start, middle);
            } else {
                return binarySearch(row, target, middle + 1, end);
            }
        } else {
            return false;
        }
    }

    public void test() {
        //{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        int target = 1;
        System.out.println(searchMatrix(matrix, 16));
        System.out.println(searchMatrix(matrix, 51));
        System.out.println(searchMatrix(matrix, 1));
        System.out.println(searchMatrix(matrix, 8));
        System.out.println(searchMatrix(matrix, 22));

    }
}
