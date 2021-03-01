package problems.easy;

/**
 * leetcode 896
 */
public class MonotonicArray {
    /**
     * 执行用时：
     * 1 ms
     * , 在所有 Java 提交中击败了
     * 100.00%
     * 的用户
     * 内存消耗：
     * 46.9 MB
     * , 在所有 Java 提交中击败了
     * 20.35%
     * 的用户
     *
     * @param A
     * @return
     */
    public boolean isMonotonic(int[] A) {
        boolean isStart = false;
        boolean up = false;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                if (!isStart) {
                    isStart = true;
                    up = A[i] < A[i + 1];
                } else if (up != A[i] < A[i + 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}
