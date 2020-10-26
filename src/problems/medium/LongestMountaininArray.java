package problems.medium;

/**
 * @author zyuanyuz
 * @since 2020/10/25 14:46
 */

/**
 * leetcode 845
 */

public class LongestMountaininArray {
    /**
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 69.49%
     * 的用户
     * 内存消耗：
     * 39.3 MB
     * , 在所有 Java 提交中击败了
     * 91.74%
     * 的用户
     *
     * @param A
     * @return
     */
    public int longestMountain(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        boolean up = true, started = false;
        int prev = A[0];
        int longestLength = 0;
        int nowLength = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > prev) {
                if (up) {
                    nowLength++;
                    started = true;
                } else {
                    nowLength = 2;
                    up = true;
                }
            } else if (A[i] < prev && started) {
                nowLength++;
                up = false;
            } else if (A[i] == prev) {
                up = true;
                nowLength = 1;
                started = false;
            }
            if (!up && nowLength > longestLength) {
                longestLength = nowLength;
            }
            prev = A[i];
        }
        return longestLength;
    }

    public static void main(String[] args) {
        LongestMountaininArray l = new LongestMountaininArray();
        System.out.println(l.longestMountain(new int[]{875, 884, 239, 731, 723, 685}));
    }
}
