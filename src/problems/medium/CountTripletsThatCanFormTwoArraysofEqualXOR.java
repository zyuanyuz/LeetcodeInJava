package problems.medium;

/**
 * leetcode 1442
 */

public class CountTripletsThatCanFormTwoArraysofEqualXOR {
    /**
     * O(n^3)复杂度，需要优化
     * 执行用时： 52 ms , 在所有 Java 提交中击败了 8.43% 的用户 内存消耗： 37.6 MB , 在所有 Java 提交中击败了 6.86%
     * 的用户
     * 
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        if (arr.length < 2) {
            return 0;
        }
        int count = 0;
        int[][] matrix = new int[arr.length][arr.length];
        // matrix[0][1] = arr[0] ^ arr[1];
        for (int i = 0; i <= arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (j == i + 1) {
                    matrix[i][j] = arr[i];
                } else {
                    matrix[i][j] = matrix[i][j - 1] ^ arr[j - 1];
                }
            }
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                for (int k = j; k <= arr.length - 1; k++) {
                    if (matrix[i][j] == (matrix[j][k] ^ arr[k])) {
                        System.out.println(i + " " + j + " " + k);
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        CountTripletsThatCanFormTwoArraysofEqualXOR c = new CountTripletsThatCanFormTwoArraysofEqualXOR();
        System.out.println(c.countTriplets(new int[] { 2, 3, 1, 6, 7 }));
    }
}